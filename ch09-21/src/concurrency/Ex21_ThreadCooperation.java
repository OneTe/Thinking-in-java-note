package concurrency;
/****************** Exercise 21 ******************
 * Create two Runnables, one with a run() that
 * starts and calls wait(). The second class should
 * capture the reference of the first Runnable object.
 * Its run() should call notifyAll() for the first
 * task after some number of seconds have passed so
 * that the first task can display a message. Test
 * your classes using an Executor.
 ***********************************************/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/22.
 */
class Coop1 implements Runnable{
    public Coop1(){System.out.println("Constructed Coop1");}

    @Override
    public void run() {
        System.out.println("Coop1 going into wait");
        synchronized(this){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        System.out.println("Coop1 exited wait");
    }
}
class Coop2 implements Runnable{
    Runnable otherTask;
    public Coop2(Runnable otherTask){
        this.otherTask = otherTask;
        System.out.println("Constructed Coop2");
    }

    @Override
    public void run() {
        System.out.println("Coop2 pausing 5 seconds");
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){

        }
        System.out.println("Coop2 calling notifyAll");
        synchronized(otherTask){
            otherTask.notifyAll();
        }
    }
}
public class Ex21_ThreadCooperation {
    public static void main(String[] args) throws Exception{
        Runnable coop1 = new Coop1(),
                coop2 = new Coop2(coop1);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(coop1);
        exec.execute(coop2);
        Thread.yield();
        exec.shutdown();
    }
}
