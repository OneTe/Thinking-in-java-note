package concurrency;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by wangcheng  on 2017/12/26.
 */
class Fibonacci1 implements Generator<Integer>,Callable<Integer>{
    private int count = 0;
    private final int n;
    Fibonacci1(int n){
        this.n = n;
    }
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }
    public Integer call(){
        int sum = 0;
        for(int i = 0;i < n;i++)
            sum += next();
        return sum;
    }
}
public class Ex5 {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results =
                new ArrayList<Future<Integer>>();
        for(int i = 0;i < 5;i++)
            results.add(exec.submit(new Fibonacci1(i)));
        Thread.yield();
        exec.shutdown();
        for(Future<Integer> fs : results)
            try{
                //get() blocks until completion:
                System.out.println(fs.get());
            }catch (Exception e){
                System.out.println(e);
            }
            // 或这样
//        for(int i = 0;i<5;i++){
//            try {
//                Future<Integer> fi = exec.submit(new Fibonacci1(i));
//                System.out.println(fi.get());
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        exec.shutdown();
    }
}
