package typeinfo;

/**
 * Created by wangcheng  on 2017/9/1.
 */
import java.util.*;
class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 =
            ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2{
    static int staticNoFinal = 147;
    static{
        System.out.println("Initializing Initable2");
    }
}

class Initable3{
    static int staticNoFinal = 74;
    static{
        System.out.println("Initializing Initable3");
    }
}
public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args){
        Class initable =Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNoFinal);
        try {
            Class initable3 = Class.forName("Initable3");//forName好像不会执行初始化了，在jdk5以前版本不一样了
        }catch (ClassNotFoundException e){

        }
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNoFinal);
    }
}
