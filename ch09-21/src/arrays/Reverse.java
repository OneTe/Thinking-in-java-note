package arrays;
//Collections类有一个reverseOrder()方法，可以反转自然的排序顺序
/**
 * Created by wangcheng  on 2017/10/17.
 */
import java.util.*;
import net.mindview.util.*;

public class Reverse {
    public static void main(String[] args){
        CompType[] a = Generated.array(new CompType[12],CompType.generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a,Collections.reverseOrder());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}
