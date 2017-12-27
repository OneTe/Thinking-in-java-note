package concurrency;
//Daemon threads don't prevent the program from ending.
//daemon线程有个特点就是"比较次要"，程序中如果所有的user线程都结束了，那这个程序本身就结束了
// ，管daemon是否结束。而user线程就不是这样，只要还有一个user线程存在，程序就不会退出。
//本例子里面改变sleep的时间可以得到不同结果
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2017/12/27.
 */
public class SimpleDaemons implements Runnable{
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        }catch (InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }
    public static void main(String[] args) throws Exception{
        for(int i = 0;i < 10;i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);//Must call before start
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
