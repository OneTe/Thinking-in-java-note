package concurrency;
/********************** Exercise 23 ***********************
 * Demonstrate that WaxOMatic.java works when
 * you use notify() instead of notifyAll().
 *********************************************************/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/26.
 */
class Car{
    private boolean waxOn;
    public synchronized void waxed(){
        waxOn = true;
        notify();
    }
    public synchronized void buffed(){
        waxOn = false;
        notify();
    }
    public synchronized void waitForWaxing() throws InterruptedException{
        while (waxOn == false){
            wait();
        }
    }
    public synchronized void waitForBuffing() throws InterruptedException{
        while (waxOn == true){
            wait();
        }
    }
}
class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car c){car = c;}

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}
class WaxOff implements Runnable{
    private Car car;
    public WaxOff(Car c){car = c;}

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}
public class Ex23_WaxOMatic2 {
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
