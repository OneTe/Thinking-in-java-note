package containers;
// TIJ4 Chapter Containers, Exercise 1, page 809
/* Create a List (try both ArrayList and LinkedList) and fill it using
* Countries. Sort the list and print it, then apply Collections.shuffle()
* to the list repeatedly, printing it each time so that you can see how
* the shuffle() method randomizes the list differently each time.
*/
/**
 * Created by wangcheng  on 2017/11/8.
 */
import java.util.*;
import net.mindview.util.*;

public class Ex1 {
    public static void main(String[] args){
        List<String> al = new ArrayList<String>();
        List<String> ll = new LinkedList<String>();
        for(int i =0 ;i < Countries.DATA.length;i++){
            al.add(Countries.DATA[i][0]);
            ll.add(Countries.DATA[i][0]);
        }
        Collections.sort(al);
        Collections.sort(ll);
        System.out.println("Countries: " + al);
        System.out.println("Countries: " + ll);
        for(int i =0;i<2;i++){
            Collections.shuffle(al);
            Collections.shuffle(ll);
            System.out.println("Countries: " + i + ": " + al);
            System.out.println("Countries: " + i + ": " + ll);
        }
    }
}
