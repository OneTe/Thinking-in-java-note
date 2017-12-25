package concurrency;

import net.mindview.util.Generator;

import java.util.Arrays;

/**
 * Created by wangcheng  on 2017/12/25.
 */
class Fibonacci implements Generator<Integer> ,Runnable{
    private int count = 0;
    private final int n;
    Fibonacci(int n){
        this.n = n;
    }
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }
    public void run(){
        Integer[] sequence = new Integer[n];
        for(int i = 0;i<n;i++)
            sequence[i] = next();
        System.out.println("Seq. of " + n + ": " + Arrays.toString(sequence));
    }
}
public class Ex2 {
    public static void main(String[] args){
        for(int i = 1;i<=5;i++)
            new Thread(new Fibonacci(i)).start();
    }
}
