package generics;

import java.util.*;

import typeinfo.pets.*;
/**
 * Created by wangcheng  on 2017/9/18.
 */
public class RandomList6<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);
    public void add(T item){storage.add(item);}
    public T select(){
        return storage.get(rand.nextInt(storage.size()));
    }
    public static void main(String[] args){
        RandomList6<Integer> it = new RandomList6<>();
        for(int i = 0;i<11;i++){
            it.add(i);
        }
        for(int i = 0;i<11;i++){
            System.out.print(it.select() + " ");
        }
        System.out.println();
        RandomList6<Pet> rp = new RandomList6<>();
        for(Pet p:Pets.arrayList(10)){
            rp.add(p);
        }
        for(int i =0;i<11;i++){
            System.out.print(rp.select() + " ");
        }
    }
}
