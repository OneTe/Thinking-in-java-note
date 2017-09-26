package generics;

/**
 * Created by wangcheng  on 2017/9/26.
 */
import java.util.*;
public class CompilerIntelligence {
    public static void main(String[] args){
        List<? extends Fruit> fruits =Arrays.asList(new Apple());
        Apple a = (Apple)fruits.get(0);//No warning
        //在调用contains()及indexOf()时，参数类型是Object，因此不涉及任何通配符
        fruits.contains(new Apple());//Argument is 'Object'
        fruits.indexOf(new Apple());//Argument is 'Object'
    }
}
