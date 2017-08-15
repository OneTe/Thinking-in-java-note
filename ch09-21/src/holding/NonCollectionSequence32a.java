package holding;

// TIJ4 Chapter Holding, Exercise 32, page 437
/* Following the example of MultiIterableClass, add reversed() and randomized()
* methods to NonCollectionSequence.java, as well as making  NonCollectionSequence.java
* implement Iterable and show that all the approaches * work in foreach statements.
*/
import typeinfo.pets.*;
import java.util.*;
/**
 * Created by wangcheng on 2017/8/15.
 */
class PetSequence1{
    protected Pet[] pets = Pets.createArray(8);
}
public class NonCollectionSequence32a extends PetSequence1 implements Iterable{
    public Iterator<Pet> iterator(){
        return new Iterator<Pet>() {
            private int index;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }
            @Override
            public Pet next() {
                return pets[index++];
            }
            public void remove(){throw new UnsupportedOperationException();}
        };
    }
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
                    public void remove(){throw new UnsupportedOperationException();}
                };
            }
        };
    }
    public Iterable<Pet> randomized(){
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> shuffled = new ArrayList<>(Arrays.asList(pets));
                Collections.shuffle(shuffled,new Random());
                return shuffled.iterator();
            }
        };
    }
    public static void main(String[] args){
        NonCollectionSequence32a nc = new NonCollectionSequence32a();
        System.out.print("pets: ");
        for(Pet p : nc.pets){
            System.out.print(p + " ");
        }
        System.out.println();
        System.out.print("reversed: ");
        for(Pet p : nc.reversed()){
            System.out.print(p + " ");
        }
        System.out.println();
        System.out.print("Randomized: ");
        for(Pet p : nc.randomized()){
            System.out.print(p + " ");
        }
    }
}
