package concurrency;
//When threads collide
//一个任务有可能在另一个任务执行第一个对currentEvenValue的递增操作之后，但是没有执行
//第二个操作之前，调用了next()方法
//而且自增操作也不是原子操作
/**
 * Created by wangcheng  on 2018/1/10.
 */
public class EvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    public int next(){
        ++currentEvenValue;//Danger point here!
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args){
        EvenChecker.test(new EvenGenerator());
    }
}
