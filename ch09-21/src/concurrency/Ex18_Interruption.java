package concurrency;
/****************** Exercise 18 ************************
 * Create a non-task class with a method that calls
 * sleep() for a long interval. Create a task that calls
 * the method in the non-task class. In main(), start the
 * task, then call interrupt() to terminate it. Make sure
 * that the task shuts down safely.
 ******************************************************/

import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/19.
 */
class NonTask{
    static void longMethod() throws InterruptedException{
        TimeUnit.SECONDS.sleep(60);
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        try {
            NonTask.longMethod();
        }catch (InterruptedException ie){
            System.out.println(ie.toString());
        }finally {
            //Any cleanup code here
        }
    }
}
public class Ex18_Interruption {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Task());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
