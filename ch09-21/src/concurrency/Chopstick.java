package concurrency;
//Chopsticks for dining philosophers
/**
 * Created by wangcheng  on 2018/1/31.
 */
public class Chopstick {
    private boolean taken = false;
    public synchronized void take() throws InterruptedException{
        while (taken){
            wait();
        }
        taken = true;
    }
    public synchronized void drop(){
        taken = false;
        notifyAll();
    }
}