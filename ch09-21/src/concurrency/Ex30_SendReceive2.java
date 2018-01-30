package concurrency;
/********************** Exercise 30 ***********************
 * Modify PipedIO.java to use a BlockingQueue instead of
 * a pipe.
 *********************************************************/

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/30.
 */
class CharQueue2 extends LinkedBlockingQueue<Character>{}
class Sender2 implements Runnable{
    private Random rand = new Random(47);
    private CharQueue2 out = new CharQueue2();

    public CharQueue2 getQueue() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (true){
                for(char c = 'A';c < 'z';c++){
                    out.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(400));
                }
            }
        }catch (InterruptedException e){
            System.out.println(e + " Sender interrupted");
        }
    }
}
class Receiver2 implements Runnable {
    private CharQueue2 in;
    public Receiver2(Sender2 sender) { in = sender.getQueue(); }
    public void run() {
        try {
            while(true) {
                // Blocks until characters are there:
                System.out.println("Read: " + in.take() + ", ");
            }
        } catch(InterruptedException e) {
            System.out.println(e + " Reader interrupted");
        }
    }
}
public class Ex30_SendReceive2 {
    public static void main(String[] args) throws Exception{
        Sender2 sender = new Sender2();
        Receiver2 receiver = new Receiver2(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
