package arrays;

/**
 * Created by wangcheng  on 2017/10/17.
 */
import java.util.*;
public class Ex25 {
    public static void main(String[] args){
        List<Integer> li = new ArrayList<>();
        System.out.println(li.getClass().getSimpleName());
        for(int i = 1;i<6;i++){
            li.add(i);
        }
        System.out.println(li.toString());
        System.out.println(li.get(4));
        li.add(6);
        li.addAll(Arrays.asList(7,8));
        System.out.println(li.toString());
    }
}
