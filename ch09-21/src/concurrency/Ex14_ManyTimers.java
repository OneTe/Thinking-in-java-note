package concurrency;
/****************** Exercise 14 ************************
 * Demonstrate that java.util.Timer scales to large numbers
 * by creating a program that generates many Timer objects
 * that perform some simple task when the timeout completes.
 ******************************************************/

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/12.
 */
public class Ex14_ManyTimers {
    public static void main(String[] args) throws Exception{
        int numOfTimers = 10;
        for(int i = 0;i < numOfTimers;i++){
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis());
                }
            },numOfTimers - 1);
        }
        //Wait for timers to expire
        TimeUnit.MILLISECONDS.sleep(2 * numOfTimers);
        System.exit(0);
    }
}
