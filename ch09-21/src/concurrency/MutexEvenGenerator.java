package concurrency;
//Preventing thread collisions with mutexes.
//使用显式的Lock重写SynchronizedEventGenerator.java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangcheng  on 2018/1/11.
 */
public class MutexEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    public int next(){
        lock.lock();
        try{
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args){
        EvenChecker.test(new MutexEvenGenerator());
    }
}
