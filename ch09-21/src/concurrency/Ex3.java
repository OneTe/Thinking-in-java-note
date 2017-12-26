package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangcheng  on 2017/12/26.
 */
class Printer1 implements Runnable{
    private static int taskCount;
    private final int id = taskCount++;
    Printer1(){
        System.out.println("Printer started,ID = " + id);
    }
    @Override
    public void run() {
        System.out.println("Stage 1..., ID = " + id);
        Thread.yield();
        System.out.println("Stage 2..., ID = " + id);
        Thread.yield();
        System.out.println("Stage 3..., ID = " + id);
        Thread.yield();
        System.out.println("Printer ended, ID = " + id);
    }
}
public class Ex3{
    public static void main(String[] args){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0;i<5;i++)
            exec.execute(new Printer1());
        exec.shutdown();
    }
}
