package concurrency;
//使用AtomicInteger来重写Atomicity.java
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangcheng  on 2018/1/11.
 */
public class AtomicIntegerTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);
    public int getValue(){return i.get();}
    private void evenIncrement(){i.addAndGet(2);}
    public void run(){
        while (true)
            evenIncrement();
    }
    public static void main(String[] args){
        //因为这个程序不会停止，所以我们添加一个timer，以便在5s后自动终止
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        },5000);//Terminate after 5 seconds
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        while (true){
            int val = ait.getValue();
            if(val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
