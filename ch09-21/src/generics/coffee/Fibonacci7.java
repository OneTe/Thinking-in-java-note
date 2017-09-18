package generics.coffee;

import java.util.Iterator;

/**
 * Created by wangcheng  on 2017/9/18.
 */
public class Fibonacci7 implements Iterable<Integer>{
    private int n ;
    Fibonacci fi = new Fibonacci();
    public Fibonacci7(int count){this.n = count;}

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n >0;
            }

            @Override
            public Integer next() {
                n--;
                return fi.next();
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args){
        Fibonacci7 fib = new Fibonacci7(20);
        for(int i : fib){
            System.out.print(i + " ");
        }
    }
}
