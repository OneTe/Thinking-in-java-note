package generics.coffee;
//Adapt the Fibonacci class to make it Iterable
/**
 * Created by wangcheng  on 2017/9/18.
 */
import java.util.*;

public class IterableFibonacci
extends Fibonacci implements Iterable<Integer>{
    private int n;
    public IterableFibonacci(int count){n = count;}
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args){
        for(int i : new IterableFibonacci(18)){
            System.out.print(i + " ");
        }
    }
}
