package concurrency;
/****************** Exercise 11 *****************
 * Create a class containing two data fields, and a
 * method that manipulates those fields in a multistep
 * process so that, during the execution of that method,
 * those fields are in an "improper state" (according to
 * some definition that you establish). Add methods to
 * read the fields, and create multiple threads to call
 * the various methods and show that the data is visible
 * in its "improper state." Fix the problem using the
 * synchronized keyword.
 ***********************************************/

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangcheng  on 2018/1/11.
 */
class Tank{
    enum State{EMPTY,LOADED};
    private State state = State.EMPTY;
    private int current_load = 0;
    public void validate(){
        if((state == State.EMPTY && current_load !=0) ||
                (state == State.LOADED && current_load == 0))
            throw new IllegalStateException();
    }
    public void fill(){
        state = State.LOADED;
        Thread.yield();
        current_load = 10;
    }
    public void drain(){
        state = State.EMPTY;
        Thread.yield();
        current_load = 0;
    }
}
class ConsistencyChecker implements Runnable{
    private static Random rnd = new Random();
    private Tank tank;
    ConsistencyChecker(Tank tank){
        this.tank = tank;
    }
    public void run(){
        for (;;) {
            if (rnd.nextBoolean())
                tank.fill();
            else
                tank.drain();
            tank.validate();
        }
    }
}
public class Ex11 {
    public static void main(String[] args){
        Thread.setDefaultUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler()
        );
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        Tank tank = new Tank();
        for(int i = 0;i < 10;i++)
            exec.execute(new ConsistencyChecker(tank));
        Thread.yield();
        exec.shutdown();
    }
}
