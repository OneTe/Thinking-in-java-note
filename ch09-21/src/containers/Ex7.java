package containers;
// TIJ4 Chapter Containers, Exercise 7, page 820
/* Create both an ArrayList and a LinkedList, and fill each using the
*  Countries.names() generator. Print each list using an ordinary
* iterator, then insert one list into the other by using a ListIterator,
* inserting at every other location. Now perform the insertion staring
* at the end of the first list and moving backwards.
*/
/**
 * Created by wangcheng  on 2017/11/8.
 */
import net.mindview.util.Countries;

import java.util.*;

public class Ex7 {
    public static void main(String[] args){
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new LinkedList<>();
        l1.addAll(Countries.names(6));
        l2.addAll(Countries.names(6));
        Iterator ll = l1.iterator();
        Iterator ll2 = l2.iterator();
        while (ll.hasNext()) System.out.print(ll.next() + " ");
        System.out.println();
        while (ll2.hasNext()) System.out.print(ll2.next() + " ");
        l1.listIterator();
        System.out.println();

        ListIterator llt1 = l1.listIterator();
        ListIterator llt2 = l2.listIterator();
        while (llt2.hasNext()){
            llt1.add((String)llt2.next());
            llt1.next();
        }
        System.out.println(l1);


        List<String> al2 = new ArrayList<String>(Countries.names(6));
        ListIterator allit2 = al2.listIterator();
        while(llt2.hasPrevious()) llt2.previous();
        while(allit2.hasNext()) allit2.next();
        while(llt2.hasNext()) {
            allit2.add((String)llt2.next());
            allit2.previous();
            allit2.previous();
        }
        System.out.println(al2);


    }
}
