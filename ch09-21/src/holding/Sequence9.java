package holding;
// TIJ4 Chapter Holding, Exercise 9, page 409
// Modify innerclasses/Sequence.java so that Sequence works with an Iterator
// instead of a Selector.
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wangcheng on 2017/8/1.
 */
public class Sequence9 {
    private ArrayList<Object> items = new ArrayList<Object>();
    public void add(Object x){
        items.add(x);
    }
    public Iterator iterator(){
        return items.iterator();
    }
    public static void main(String[] args){
        Sequence9 sequence9 = new Sequence9();
        for(int i = 0;i<9;i++){
            sequence9.add(Integer.toString(i));
        }
        Iterator it = sequence9.iterator();
        while (it.hasNext()){
            System.out.println(it.next() + " ");
        }
    }
}
