package generics;
//Using adapters to simulate latent typing
/**
 * Created by wangcheng  on 2017/10/13.
 */
import generics.coffee.*;
import java.util.*;
import net.mindview.util.*;

interface Addable<T>{void add(T t);}

public class Fill2 {
    //ClassToken version:
    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> classToken,int size){
        for(int i = 0;i<size;i++)
            try {
                addable.add(classToken.newInstance());
            }catch (Exception e){
                throw new RuntimeException(e);
            }
    }
    //Generator version:
    public static <T> void fill(Addable<T> addable,
                                Generator<T> generator,int size){
        for(int i = 0;i<size;i++)
            addable.add(generator.next());
    }
 }
 //To adapt a base type,you must use composition,
//Make any collection Addable using composition:
class AddableCollectionAdapter<T> implements Addable<T>{
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c){
        this.c = c;
    }
    public void add(T item){c.add(item);}
 }

 class Adapter{
    public static <T>
     Addable<T> collectionAdapter(Collection<T> c){
        return new AddableCollectionAdapter<>(c);
    }
 }

 class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T>{
    public void add(T item){super.add(item);}
 }

 class Fill2Test{
    public static void main(String[] args){
        //Adapt a collection:
        List<Coffee> carrier = new ArrayList<Coffee>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier),Coffee.class,3);
        //Helper method captures the type:
        Fill2.fill(Adapter.collectionAdapter(carrier),Latte.class,2);
        for(Coffee c : carrier)
            System.out.println(c);
        System.out.println("-----------------");
        //Use an adapted class:
        AddableSimpleQueue<Coffee> coffeeQueue =
                new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue,Mocha.class,4);
        Fill2.fill(coffeeQueue,Latte.class,1);
        for(Coffee c : coffeeQueue)
            System.out.println(c);
    }
 }