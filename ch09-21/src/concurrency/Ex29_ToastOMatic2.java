package concurrency;
/********************** Exercise 29 ***********************
 * Modify ToastOMatic.java to create peanut butter and jelly
 * on toast sandwiches using two separate assembly lines
 * (one for peanut butter, the second for jelly, then
 * merging the two lines).
 *********************************************************/

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/30.
 */
class Toast29{
    public enum Status{
        DAY,
        BUTTERED,
        JAMMED,
        READY{
            @Override
            public String toString() {
                return BUTTERED.toString() + " & " + JAMMED.toString();
            }
        }
    }
    private Status status = Status.DAY;
    private final int id;
    public Toast29(int idn){id = idn;}
    public void butter(){
        status = (status == Status.DAY) ? Status.BUTTERED : Status.READY;
    }
    public void jam(){
        status = (status == Status.DAY) ? Status.JAMMED : Status.READY;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + " : " + status;
    }
}
class ToastQueue29 extends LinkedBlockingQueue<Toast29>{}
class Toaster29 implements Runnable{
    private ToastQueue29 toastQueue;
    private int count;
    private Random rand = new Random(47);
    public Toaster29(ToastQueue29 tq){toastQueue = tq;}
    public void run(){
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                //Make Toast
                Toast29 t = new Toast29(count++);
                System.out.println(t);
                toastQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster Off");
    }
}
class Butterer29 implements Runnable{
    private ToastQueue29 inQueue,butteredQueue;
    public Butterer29(ToastQueue29 in,ToastQueue29 buttered){
        inQueue = in;
        butteredQueue = buttered;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                Toast29 t = inQueue.take();
                t.butter();
                System.out.println(t);
                butteredQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer Off");
    }
}
class Jammer29 implements Runnable{
    private ToastQueue29 inQueue,jammedQueue;
    public Jammer29(ToastQueue29 in,ToastQueue29 jammed){
        inQueue = in;
        jammedQueue = jammed;
    }
    public void run(){
        try{
            while (!Thread.interrupted()){
                Toast29 t = inQueue.take();
                t.jam();
                System.out.println(t);
                jammedQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer Off");
    }
}
class Eater29 implements Runnable{
    private ToastQueue29 finishedQueue;
    public Eater29(ToastQueue29 finished){
        finishedQueue = finished;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast29 t = finishedQueue.take();
                if(t.getStatus() != Toast29.Status.READY){
                    System.out.println(">>> Error: " + t);
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
//Outputs alternate inputs on alternate channels:
class Alternator implements Runnable{
    private ToastQueue29 inQueue,out1Queue,out2Queue;
    private boolean outTo2; //control alternation
    public Alternator(ToastQueue29 in,ToastQueue29 out1,ToastQueue29 out2){
        inQueue = in;
        out1Queue = out1;
        out2Queue = out2;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast29 t = inQueue.take();
                if(!outTo2){
                    out1Queue.put(t);
                }else {
                    out2Queue.put(t);
                }
                outTo2 = !outTo2;//change state for next time
            }
        }catch (InterruptedException e){
            System.out.println("Alternator interrupted");
        }
        System.out.println("Alternator Off");
    }
}
//Accept toasts on either channel,and relays them on to a "single" successor
class Merger implements Runnable{
    private ToastQueue29 in1Queue,in2Queue,toBeButteredQueue,
        toBeJammedQueue,finishedQueue;
    public Merger(ToastQueue29 in1,ToastQueue29 in2,ToastQueue29 toBeButtered,ToastQueue29 toBeJammed,
                    ToastQueue29 finished){
        in1Queue = in1;
        in2Queue = in2;
        toBeButteredQueue = toBeButtered;
        toBeJammedQueue = toBeJammed;
        finishedQueue = finished;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast29 t = null;
                while (t == null){
                    t = in1Queue.poll(50,TimeUnit.MILLISECONDS);
                    if(t != null){
                        break;
                    }
                    t = in2Queue.poll(50,TimeUnit.MILLISECONDS);
                }
                //Ready toast onto the proper queue
                switch (t.getStatus()){
                    case BUTTERED:
                        toBeJammedQueue.put(t);
                        break;
                    case JAMMED:
                        toBeButteredQueue.put(t);
                        break;
                    default:
                        finishedQueue.put(t);
                }
            }
        }catch (InterruptedException e){
            System.out.println("Merger interrupted");
        }
        System.out.println("Merger Off");
    }
}
public class Ex29_ToastOMatic2 {
    public static void main(String[] args) throws Exception{
        ToastQueue29
                dryQueue = new ToastQueue29(),
                butteredQueue = new ToastQueue29(),
                toBeButteredQueue = new ToastQueue29(),
                jammedQueue = new ToastQueue29(),
                toBeJammedQueue = new ToastQueue29(),
                finishedQueue = new ToastQueue29();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster29(dryQueue));
        exec.execute(new Alternator(dryQueue,toBeButteredQueue,toBeJammedQueue));
        exec.execute(new Butterer29(toBeButteredQueue,butteredQueue));
        exec.execute(new Jammer29(toBeJammedQueue,jammedQueue));
            exec.execute(new Merger(butteredQueue,jammedQueue,toBeButteredQueue,toBeJammedQueue,finishedQueue));
        exec.execute(new Eater29(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
