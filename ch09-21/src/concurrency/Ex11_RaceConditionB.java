package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangcheng  on 2018/1/11.
 */
class SafeTank extends Tank{
    public synchronized void validate(){super.validate();}
    public synchronized void fill(){super.fill();}
    public synchronized void drain(){super.drain();}
}
public class Ex11_RaceConditionB {
    public static void main(String[] args){
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("Press Control-C to exit!");
        SafeTank safeTank = new SafeTank();
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i < 10;i++)
            exec.execute(new ConsistencyChecker(safeTank));
        Thread.yield();
        exec.shutdown();
    }
}
