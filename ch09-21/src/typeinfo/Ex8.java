package typeinfo;

/**
 * Created by wangcheng  on 2017/9/1.
 */
class A1 {}
class A11 extends A1{}

public class Ex8 {
    static void printC(Class c){
        System.out.println(c.getSuperclass());
    }
    public static void main(String[] args){
        printC(new A11().getClass());
    }
}
