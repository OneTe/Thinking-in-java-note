package generics;
//泛型方法与可变参数
/**
 * Created by wangcheng  on 2017/9/19.
 */
import java.util.*;
public class GenericVarargs {
    //与java.util.ArrayList.asList()方法相同的功能
    public static <T> List<T> makeList(T... args){
        List<T> result = new ArrayList<>();
        for(T item : args){
            result.add(item);
        }
        return result;
    }
    public static void main(String[] args){
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A","B","C");
        System.out.println(ls);
    }
}
