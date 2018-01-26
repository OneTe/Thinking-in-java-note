package concurrency;
//当notifyAll()因某个特定锁而被调用时，只有等待这个锁的任务才会被唤起
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/23.
 */
class Blocker{
    synchronized void waitingCall(){
        try{
            while (!Thread.interrupted()){
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        }catch (InterruptedException e){
            //
        }
    }
    synchronized void prod(){notify();}
    synchronized void prodAll(){notifyAll();}
}
class Task1 implements Runnable{
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
class Task2 implements  Runnable{
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
public class NotifyVsNotifyAll {
    public  static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i < 5;i++){
            exec.execute(new Task1());
        }
        exec.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if(prod){
                    System.out.println("\nnotify() ");
                    Task1.blocker.prod();
                    prod = false;
                }else {
                    System.out.println("\nnotifyAll() ");
                    Task1.blocker.prodAll();
                    prod = true;
                }
            }
        },400,400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("Task2.blocker.prodAll() ");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\nShutting down");
        exec.shutdownNow();//Interrupt all tasks
    }
}
