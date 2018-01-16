package concurrency;
/****************** Exercise 15 ************************
 * Create a class with three methods containing critical
 * sections that all synchronize on the same object. Create
 * multiple tasks to demonstrate that only one of these
 * methods can run at a time. Now modify the methods so
 * that each one synchronizes on a different object and
 * show that all three methods can be running at once.
 ******************************************************/
/**
 * Created by wangcheng  on 2018/1/16.
 */
class SingleSynch{
    public synchronized void f(){
        for(int i = 0;i < 5;i++){
            System.out.println("f()");
            Thread.yield();
        }
    }
    public synchronized void g(){
        for(int i = 0;i < 5;i++){
            System.out.println("g()");
            Thread.yield();
        }
    }
    public synchronized void h(){
        for(int i = 0;i < 5;i++){
            System.out.println("h()");
            Thread.yield();
        }
    }
}
class TripleSynch{
    private Object syncObjectG = new Object();
    private Object syncObjectH = new Object();
    public synchronized void f(){
        for(int i = 0;i < 5;i++){
            System.out.println("f()");
            Thread.yield();
        }
    }
    public void g(){
        synchronized(syncObjectG){
            for(int i = 0;i < 5;i++){
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
    public void h(){
        synchronized(syncObjectH){
            for(int i = 0;i < 5;i++){
                System.out.println("h()");
                Thread.yield();
            }
        }
    }
}
public class Ex15_SyncObject {
    public static void main(String[] args) throws Exception{
        final SingleSynch singleSynch = new SingleSynch();
        final TripleSynch tripleSynch = new TripleSynch();
        System.out.println("Test SignleSynch...");
        Thread t1 = new Thread(){
            @Override
            public void run() {
                singleSynch.f();
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                singleSynch.g();
            }
        };
        t2.start();
        singleSynch.h();
        t1.join();
        t2.join();

    }
}
