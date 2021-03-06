package concurrency;
//Interrupting a blocked thread.
//三种不同类型的阻塞，SleepBlocked是可中断的阻塞类型
//IOBlocked和synchronizedBlocked是不可中断的阻塞示例
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/18.
 */
class SleepBlocked implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}
class IOBlocked implements Runnable{
    private InputStream in;
    public IOBlocked(InputStream is){in = is;}

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read():");
            in.read();
        }catch (IOException e){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted from blocked I/O");
            }else {
                throw new RuntimeException();
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
class synchronizedBlocked implements Runnable{
    public synchronized void f(){
        while (true){//Never releases lock
            Thread.yield();
        }
    }
    public synchronizedBlocked(){
        new Thread(){
            public void run(){
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting synchronizedBlocked.run()");
    }
}
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException{
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);//Interrupts if running
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }
    public static  void main(String[] args) throws Exception{
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new synchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0); // ....since last 2 interrupts failed
    }
}
