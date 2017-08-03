package holding;
//TreeSet将元素存储在红-黑树数据结构中
import java.util.*;

/**
 * Created by wangcheng on 2017/8/3.
 */
public class SortedSetOfInteger {
    public static void main(String[] args){
        Random rand = new Random();
        SortedSet<Integer> intset = new TreeSet<>();
        for(int i = 0 ;i<10000;i++){
            intset.add(rand.nextInt(30));
        }
        System.out.println(intset);
    }
}
