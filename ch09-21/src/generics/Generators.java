package generics;
//a utility to use with Generators

import java.util.*;

import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;
import generics.coffee.Fibonacci;
import net.mindview.util.*;

/**
 * Created by wangcheng  on 2017/9/19.
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen ,int n){
        for(int i =0;i<n;i++){
            coll.add(gen.next());
        }
        return coll;
    }
    public static void main(String[] args){
        Collection<Coffee> coffees = fill(new ArrayList<>(),new CoffeeGenerator(),4);
        for(Coffee c : coffees){
            System.out.println(c);
        }
        Collection<Integer> it = fill(new ArrayList<>(),new Fibonacci(),10);
        System.out.println(it);
    }
}
