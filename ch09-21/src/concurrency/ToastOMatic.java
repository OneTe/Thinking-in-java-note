package concurrency;
//A toaster that uses queue.

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/29.
 */
class Toast{
    public enum Status{DRY,BUTTERED,JAMMED}
    private Status status = Status.DRY;
    private final int id;
    public Toast(int idn){id = idn;}
    public void butter(){status = Status.BUTTERED;}
    public void jam(){status = Status.JAMMED;}
    public Status getStatus(){return status;}
    public int getId(){return id;}

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }
}
class ToastQueue extends LinkedBlockingQueue<Toast>{}
class Toaster implements Runnable{
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);
    public Toaster(ToastQueue tq){toastQueue = tq;}

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                //Make toast
                Toast t = new Toast(count++);
                System.out.println(t);
                //Insert into queue:
                toastQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster Off");
    }
}
//Apply butter to toast:
class Butterer implements Runnable{
    private ToastQueue dryQueue,butteredQueue;
    public Butterer(ToastQueue dry,ToastQueue buttered){
        dryQueue = dry;
        butteredQueue = buttered;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                //Blocks until next piece of toast is available
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                //Insert into queue:
                butteredQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer Off");
    }
}
//Apply jam to buttered toast:
class Jammer implements Runnable{
    private ToastQueue butteredQueue,finishedQueue;
    public Jammer(ToastQueue buttered,ToastQueue finished){
        butteredQueue = buttered;
        finishedQueue = finished;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                //Blocks until next piece of toast is available
                Toast t = butteredQueue.take();
                t.jam();
                System.out.println(t);
                //Insert into queue:
                finishedQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer Off");
    }
}
//Consume the toast:
class Eater implements Runnable{
    private ToastQueue finishedQueue;
    private int count = 0;
    public Eater(ToastQueue finished){
        finishedQueue = finished;
    }
    public void run(){
        try {
            while (!Thread.interrupted()) {
                Toast t = finishedQueue.take();
                //Verify that the toast is coming in order,
                //and that all pieces are getting jammed:
                if(t.getId() != count++ || t.getStatus() != Toast.Status.JAMMED){
                    System.out.println(">>>>Error: " + t);
                    System.exit(1);
                }else {
                    System.out.println("Chomp! " + t);
                }
            }
        }catch (InterruptedException e){
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater Off");
    }
}
public class ToastOMatic {
    public static void main(String[] args) throws Exception{
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exex = Executors.newCachedThreadPool();
        exex.execute(new Toaster(dryQueue));
        exex.execute(new Butterer(dryQueue,butteredQueue));
        exex.execute(new Jammer(butteredQueue,finishedQueue));
        exex.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exex.shutdownNow();
    }
}
