package holding;
import java.util.*;

import Interfaces.test.Interface;
import typeinfo.pets.*;
/**
 * Created by wangcheng on 2017/8/15.
 */
public class NonCollectionSequence32 extends NonCollectionSequence{
    public Iterable<Pet> reversed(){
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    int current = pets.length - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public Pet next() {
                        return pets[current--];
                    }
                    public void remove(){
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
    public Iterable<Pet> randomized(){
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                Random rand = new Random(47);
                List<Pet> ls = new ArrayList<>(Arrays.asList(pets));
                Collections.shuffle(ls,rand);
                return ls.iterator();
            }
        };
    }
    public static void main(String[] args){
        NonCollectionSequence32 nc = new NonCollectionSequence32();
        InterfaceVsIterator.display(nc.iterator());
        InterfaceVsIterator.display(nc.reversed().iterator());
        InterfaceVsIterator.display(nc.randomized().iterator());
    }
}
