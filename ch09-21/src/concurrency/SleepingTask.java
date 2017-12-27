package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2017/12/26.
 */
public class SleepingTask extends LiftOff {
    public void run(){
        try {
            while (countDown-- > 0){
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){//在run()被捕获，因为异常不能跨线程传播回main()
            System.err.println("Interrupted");
        }
    }
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5;i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }
}
