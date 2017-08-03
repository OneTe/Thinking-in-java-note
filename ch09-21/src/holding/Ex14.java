package holding;
// TIJ4 Chapter Holding, Exercise 14, page 412
/* Create an empty LlinkedList<Integer>. Using a ListIterator, add Integers
* to the list by always inserting them in the middle of the list.
*/
import java.util.LinkedList;

/**
 * Created by wangcheng on 2017/8/3.
 */
import java.util.*;
public class Ex14 {
    static void addMiddle(LinkedList<Integer> l,Integer[] ia){
        for(Integer i : ia){
            ListIterator<Integer> it = l.listIterator((l.size())/2);
            it.add(i);
            System.out.println(l);
        }
    }
    public static void main(String[] args){
        LinkedList<Integer> li = new LinkedList<>();
        Integer[] x = {0,1,2,3,4,5,6,7};
        Ex14.addMiddle(li,x);

    }
}
