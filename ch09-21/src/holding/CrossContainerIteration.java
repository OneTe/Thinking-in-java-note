package holding;

/**
 * Created by wangcheng on 2017/8/1.
 */
import java.util.*;
public class CrossContainerIteration {
    public static void display(Iterator<Integer> it){
        while(it.hasNext()){
            Integer i = it.next();
            System.out.println("id: " + i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        ArrayList<Integer> al = new ArrayList<>();
        for(int i =0;i<5;i++) al.add(i);
        LinkedList<Integer> ld = new LinkedList<Integer>(al);
        HashSet<Integer> hs = new HashSet<>(al);
        TreeSet<Integer> ts = new TreeSet<>(al);
        display(al.iterator());
        display(ld.iterator());
        display(hs.iterator());
        display(ts.iterator());
    }
}
