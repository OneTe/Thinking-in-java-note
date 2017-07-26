package holding;
//simple container example (produces compiler warnings).
//{ThrowsException}
//数组有固定的尺寸，在使用时不怎么方便，因为不知道需要多少个对象，而java的容器类解决了这个问题，其中基本的类型是List，Set，Queue，Map
//这些对象类型也称为集合类
/**
 * Created by wangcheng on 2017/7/26.
 */
import Interfaces.interfaceprocessor.Apply;

import java.util.*;
class Apple{
    private static long counter;
    private final long id = counter++;
    public long id(){return id;}
}
class Orange{}
public class ApplesAndOrangesWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        ArrayList apples = new ArrayList();
        for(int i = 0;i<3;i++){
            apples.add(new Apple());
            //Not prevented from adding an orange to apples:
        }
        apples.add(new Orange());
        for(int i = 0; i <apples.size();i++){
            ((Apple)apples.get(i)).id();
            System.out.println( ((Apple)apples.get(i)).id());
            //Orange is detected only at run time
        }
    }
//    public static void main(String[] args){
//        //想要定义用来保存Apple对象的ArrayLis，你可以声明ArrayList<Apple>，其中尖括号里面是参数类型（可以有多个）
//        //它指定了这个容器可以保存的类型。通过使用泛型，就可以在编译期将错误类型的对象放置到容器中
//        ArrayList<Apple> apples = new ArrayList<Apple>();
//        for(int i = 0;i<3;i++){
//            apples.add(new Apple());
//            //Not prevented from adding an orange to apples:
//        }
//        //Compile-time error:
//        //apples.add(new Orange());
//        for(int i = 0;i<apples.size();i++){
        //类型转化也是不必要的了，因为List知道它保存的是什么类型
//            System.out.println(apples.get(i).id());
//        }
//        for(Apple c : apples){
//            System.out.println(c.id());
//        }
//    }

}







