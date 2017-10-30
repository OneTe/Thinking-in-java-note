package containers;

/**
 * Created by wangcheng  on 2017/10/30.
 */
import java.util.*;
import net.mindview.util.*;

class Letters implements Generator<Pair<Integer,String>>,Iterable<Integer>{
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    public Pair<Integer,String> next(){
        return new Pair<Integer, String>(
                number++, "" + letter++
        );
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}
public class MapDataTest {
    public static void main(String[] args){
        System.out.println(MapData.map(new Letters(),11));
        // Two separate Generators:
        System.out.println(MapData.map(new CountingGenerator.Character(),new RandomGenerator.String(3),8));
        // A key Generator and a single value:
        System.out.println(MapData.map(new CountingGenerator.Character(),"Value",6));
    }
}
