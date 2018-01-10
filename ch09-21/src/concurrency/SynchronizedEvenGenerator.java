package concurrency;
//Simplifying mutexes with the synchronized keyword.
/**
 * Created by wangcheng  on 2018/1/10.
 */
public class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    public synchronized int next(){
        ++currentEvenValue;
        Thread.yield();//Cause failure faster
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args){
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
