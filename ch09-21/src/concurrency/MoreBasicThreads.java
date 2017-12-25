package concurrency;
//Adding more threads.
/**
 * Created by wangcheng  on 2017/12/25.
 */
public class MoreBasicThreads {
    public static void main(String[] args){
        for(int i = 0;i < 5;i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff");
    }
}
