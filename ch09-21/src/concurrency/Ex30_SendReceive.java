package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/30.
 */
class Chars{
    private char c;
    public Chars(char c){this.c = c;}

    @Override
    public String toString() {
        return String.valueOf(c);
    }
}
class CharQueue extends LinkedBlockingQueue<Chars>{}
class Sender30 implements Runnable{
    private CharQueue charQueue;

    public Sender30(CharQueue cq){charQueue = cq;}

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                for(char c = 'A';c < 'z';c++){
                    charQueue.put(new Chars(c));
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }
        }catch (InterruptedException e){
            System.out.println("Sender30 interrupted");
        }
        System.out.println("Sender30 off");
    }
}
class Receiver30 implements Runnable{
    private CharQueue charQueue;
    public Receiver30(CharQueue cq){charQueue = cq;}

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Chars c =  charQueue.take();
                System.out.println(c);
            }
        }catch (InterruptedException e){
            System.out.println("Receiver30 interrupted");
        }
        System.out.println("Receiver30 Off");
    }
}
public class Ex30_SendReceive {
    public static void main(String[] args) throws Exception {
        CharQueue charQueue = new CharQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Sender30(charQueue));
        exec.execute(new Receiver30(charQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
