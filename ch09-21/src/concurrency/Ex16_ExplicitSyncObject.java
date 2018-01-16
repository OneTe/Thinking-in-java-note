package concurrency;
//Modify Exercise 15 to use explicit lock objects.

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangcheng  on 2018/1/16.
 */
class ExplicitSingleSynch{
    private Lock lock = new ReentrantLock();
    public void f(){
        lock.lock();
        try{
            for(int i = 0;i < 5;i++){
                System.out.println("f()");
                Thread.yield();
            }
        }finally {
            lock.unlock();
        }
    }
    public void g(){
        lock.lock();
        try{
            for(int i = 0;i < 5;i++){
                System.out.println("g()");
                Thread.yield();
            }
        }finally {
            lock.unlock();
        }
    }
    public void h(){
        lock.lock();
        try{
            for(int i = 0;i < 5;i++){
                System.out.println("h()");
                Thread.yield();
            }
        }finally {
            lock.unlock();
        }
    }
}
class ExplicitTripleSynch{
    private Lock lockF = new ReentrantLock();
    private Lock lockG = new ReentrantLock();
    private Lock lockH = new ReentrantLock();
    public void f(){
        lockF.lock();
        try {
            for(int i = 0;i < 5;i++){
                System.out.println("f()");
                Thread.yield();
            }
        }finally {
            lockF.unlock();
        }
    }
    public void g(){
        lockG.lock();
        try {
            for(int i = 0;i < 5;i++){
                System.out.println("g()");
                Thread.yield();
            }
        }finally {
            lockG.unlock();
        }
    }
    public void h(){
        lockH.lock();
        try {
            for(int i = 0;i < 5;i++){
                System.out.println("h()");
                Thread.yield();
            }
        }finally {
            lockH.unlock();
        }
    }
}
public class Ex16_ExplicitSyncObject {
    public static void main(String[] args) throws Exception{
        final ExplicitSingleSynch singleSynch =
                new ExplicitSingleSynch();
        final ExplicitTripleSynch tripleSynch =
                new ExplicitTripleSynch();
        System.out.println("Test ExplicitSigleSynch...");
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
                singleSynch.f();
            }
        };
        t2.start();
        singleSynch.h();
        //在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。(Waits for this thread to die.)
        t1.join();//Wait for t1 to finish its work
        t2.join();//Wait for t2 to finish its work
        //System.out.println("abc!");
        System.out.println("Test ExplicitTripleSynch...");
        new Thread(){
            @Override
            public void run() {
                tripleSynch.f();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                tripleSynch.g();
            }
        }.start();
        tripleSynch.h();
    }
}
