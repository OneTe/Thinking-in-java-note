package arrays;
//Implementing Comparable in a class.
//java有两种方式来提供比较功能，第一种是实现java.lang.Comparable接口
/**
 * Created by wangcheng  on 2017/10/17.
 */
import java.util.*;
import net.mindview.util.*;

public class CompType implements Comparable<CompType>{
    int i;
    int j;
    private static int count = 1;
    public CompType(int n1,int n2){
        i = n1;
        j = n2;
    }
    public String toString(){
        String result = "[i= " + i + ", j = " + j + "]";
        if(count++ % 3 == 0){
            result +="\n";
        }
        return result;
    }

    @Override
    public int compareTo(CompType rv) {
        //返回负值/零/正数
        return (i < rv.i ? -1 : (i == rv.i?0:1));
    }
    private static Random r = new Random(47);
    public static Generator<CompType> generator(){
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100),r.nextInt(100));
            }
        };
    }
    public static void main(String[] args){
        CompType[] a = Generated.array(new CompType[12],generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}
