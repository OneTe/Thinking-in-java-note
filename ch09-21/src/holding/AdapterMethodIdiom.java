package holding;
//The "Adapter Method" idiom allows you to use foreach
import java.util.*;
/**
 * Created by wangcheng on 2017/8/15.
 */
class ReversibleArrayList<T> extends ArrayList<T>{
    public ReversibleArrayList(Collection<T> c){super(c);}
    public Iterable<T> reversed(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }
                    public void remove(){
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
public class AdapterMethodIdiom {
    public static void main(String[] args){
        ReversibleArrayList<String> ral =
                new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));
        //Grabs the ordinary iterator via iterator():
        for(String s : ral){
            System.out.print(s + " ");
        }
        System.out.println();
        //Hand it the Iterable of your choice
        for(String s: ral.reversed()){
            System.out.print(s + " ");
        }
    }
}
