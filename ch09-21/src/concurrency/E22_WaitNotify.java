package concurrency;
//The second version using wait()

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/23.
 */
public class E22_WaitNotify {
    public static void main(String[] args) throws Exception{
        final Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(;;){
                    try{
                        TimeUnit.MILLISECONDS.sleep(100);
                        synchronized(this){notify();}
                    }catch (InterruptedException e){
                        return;
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(;;){
                    try {
                        synchronized(r1){
                            r1.wait();
                        }
                    }catch (InterruptedException e){
                        return;
                    }
                    System.out.println("Cycled");
                }
            }
        };
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(r1);
        exec.execute(r2);
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}
