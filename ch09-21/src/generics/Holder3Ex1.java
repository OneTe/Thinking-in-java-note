package generics;

import typeinfo.pets.*;

/**
 * Created by wangcheng  on 2017/9/15.
 */
public class Holder3Ex1<T> {
    private T a;
    public Holder3Ex1(T a){this.a = a;}
    public void set(T a){this.a = a;}
    public T get(){return a;}
    public static void main(String[] args){
        Holder3Ex1<Pet> h3 = new Holder3Ex1<>(new Pet());
        Pet a = h3.get();
        System.out.println(a);
        h3.set(new Dog());
        System.out.println(h3.get());
    }
}
