package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangcheng  on 2017/12/26.
 */
public class Ex4 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i<=5;i++)
            exec.execute(new Fibonacci(i));
        Thread.yield();
        exec.shutdown();

        exec = Executors.newFixedThreadPool(5);
        for(int i = 0;i<=5;i++)
            exec.execute(new Fibonacci(i));
        Thread.yield();
        exec.shutdown();

        exec = Executors.newSingleThreadExecutor();
        for(int i = 0;i<=5;i++)
            exec.execute(new Fibonacci(i));
        Thread.yield();
        exec.shutdown();
    }
}
