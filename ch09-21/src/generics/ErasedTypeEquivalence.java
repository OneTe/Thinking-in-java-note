package generics;

/**
 * Created by wangcheng  on 2017/9/20.
 */
import java.util.*;
public class ErasedTypeEquivalence {
    public static void main(String[] args){
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
