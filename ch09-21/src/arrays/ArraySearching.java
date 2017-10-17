package arrays;
//Using Arrays.binarySarch(),必须在已排好序的数组才能使用这个方法
/**
 * Created by wangcheng  on 2017/10/17.
 */
import java.util.*;
import net.mindview.util.*;

public class ArraySearching {
    public static void main(String[] args){
        Generator<Integer> gen =
                new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(Generated.array(new Integer[25],gen));
        Arrays.sort(a);//如果没有排序列，会出现意想不到的结果
        System.out.println("Sorted arrays: " + Arrays.toString(a));
        while (true){
            int r = gen.next();
            int location = Arrays.binarySearch(a,r);
            if(location >= 0) {
                System.out.println("Location of " + r + " is " + location +
                        ", a[" + location + "] = " + a[location]);
                break;
            }
        }
    }
}
