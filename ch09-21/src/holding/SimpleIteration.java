package holding;

/**
 * Created by wangcheng on 2017/7/28.
 */
import java.util.*;
public class SimpleIteration {
    public static void main(String[] args){
        List<Integer> lt = new ArrayList<>();
        for(int i = 0;i<10;i++) lt.add(i);
        Iterator<Integer> iterator = lt.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println("i:" + i + "");
        }
        System.out.println();
        for(Integer a :lt)
            System.out.println("i:" + a + "");
        System.out.println();
        iterator = lt.iterator();
        for(int i =0;i<6;i++){
            iterator.next();
            iterator.remove();
        }
        System.out.println(lt);
    }
}
