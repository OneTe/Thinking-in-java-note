package generics;

/**
 * Created by wangcheng  on 2017/9/21.
 */
import java.util.*;
import java.lang.reflect.*;
public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind){this.kind = kind;}
    T[] create(int size){
        //在泛型中创建数组，推荐使用Array.newInstance()
        return (T[])Array.newInstance(kind,size);
        //return Array.newInstance(kind,size);
    }
    public static void main(String[] args){
        ArrayMaker<String> stringArrayMaker =
                new ArrayMaker<>(String.class);
        String[] stringArray = stringArrayMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
