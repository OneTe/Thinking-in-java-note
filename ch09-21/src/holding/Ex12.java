package holding;

/**
 * Created by wangcheng on 2017/8/2.
 */
import java.util.*;
public class Ex12 {
    public static void main(String[] args){
        List<Integer> li = new ArrayList<>();
        for(int i =0;i<6;i++)  {
            li.add(i);
        }
        //for(Integer i :li) System.out.println(i);
        List<Integer> sec = new ArrayList<>();
        ListIterator<Integer> firLi = li.listIterator();
        while (firLi.hasNext()){
            Integer i = firLi.next();
            System.out.println(i + " ");
        }
        while (firLi.hasPrevious()){
            Integer j = firLi.previous();
            sec.add(j);
        }
        ListIterator<Integer> secli = sec.listIterator();
        while (secli.hasNext()){
            System.out.println(secli.next() + " ");
        }
    }
}
