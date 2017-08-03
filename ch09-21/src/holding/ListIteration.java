package holding;

/**
 * Created by wangcheng on 2017/8/2.
 */
import java.util.*;
public class ListIteration {
    public static void main(String[] args){
        List<Integer> it = Arrays.asList(0,1,2,3,4,5);
        //for(Integer i : it) System.out.println(i);
        ListIterator<Integer> ia = it.listIterator();
        while (ia.hasNext()){
            System.out.println(ia.next() + ", " + ia.nextIndex() + ", " + ia.previousIndex() + "; ");
        }
        System.out.println();
        while (ia.hasPrevious()){
            System.out.println(ia.previous() + " ");
        }
        System.out.println();
        System.out.println(it);
        ia = it.listIterator(3);
        while (ia.hasNext()){
            ia.next();
            ia.set(9);
        }
        System.out.println(it);
    }
}
