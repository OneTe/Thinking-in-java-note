package concurrency;
//Daemon threads don't run the finally clause

import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/3.
 */
class ADaemon implements Runnable{
    public void run(){
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println("Exiting via InterruptedException");
        }finally {
            System.out.println("This should always run?");
        }
    }
}
public class DaemonDontRunFinally {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
