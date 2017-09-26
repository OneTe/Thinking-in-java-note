package generics;
//超类型通配符，可以声明是由某个特定类的任何基类来界定，方法指定是<? super MyClass> ,甚至使用类型参数
//<? super T>, 不能声明<T super MyClass>
/**
 * Created by wangcheng  on 2017/9/26.
 */
import java.util.*;
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples){
        apples.add(new Apple());
        apples.add(new Jonathan());
        //apples.add(new Fruit()); //Error
    }
}
