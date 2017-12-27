package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2017/12/26.
 */
class SleepingTask2 implements Runnable{
    private static Random rnd = new Random();
    private final int sleep_time = rnd.nextInt(10) + 1;
    public void run(){
        try{
            TimeUnit.SECONDS.sleep(sleep_time);
        }catch (InterruptedException e){
            System.err.println("Interrupted: " + e);
        }
        System.out.println(sleep_time);
    }
}
public class Ex6 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i < 5;i++)
            exec.execute(new SleepingTask2());
        Thread.yield();
        exec.shutdown();
    }
}
