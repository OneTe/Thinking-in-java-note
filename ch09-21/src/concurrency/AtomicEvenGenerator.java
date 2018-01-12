package concurrency;
//Atomic classes are occasionally useful in regular code

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangcheng  on 2018/1/12.
 */
public class AtomicEvenGenerator extends IntGenerator{
    private AtomicInteger currentEvenValue =
            new AtomicInteger(0);
    public int next(){
        return currentEvenValue.addAndGet(2);
    }
    public static void main(String[] args){
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
