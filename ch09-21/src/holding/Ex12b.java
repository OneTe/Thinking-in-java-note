package holding;
// TIJ4 Chapter Holding, Exercise 12, page 410
/* Create and populate a List<Integer>. Create a second List<Integer> of the
* same size as the first, and use ListIterator to read elements of the first
* List and insert them into the second in reverse order. (You may want to
* explore a number of different ways to solve this problem.)
*/
/**
 * Created by wangcheng on 2017/8/3.
 */
import java.util.*;
public class Ex12b {
    public static void main(String[] args){
        List<Integer> li1 = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        List<Integer> li2 = new ArrayList<>(Arrays.asList(5,6,7,8,9));
        //start li1 at the end:
        ListIterator<Integer> lt1 = li1.listIterator(5);
        ListIterator<Integer> lt2 = li2.listIterator();
        while(lt2.hasNext()){
            lt2.next();
            lt2.set(lt1.previous());
        }
        System.out.println(li1);
        System.out.println(li2);
    }
}
