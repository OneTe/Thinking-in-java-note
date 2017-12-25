package concurrency;
//The most basic use of the Thread class.
/**
 * Created by wangcheng  on 2017/12/25.
 */
public class BasicThreads {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
