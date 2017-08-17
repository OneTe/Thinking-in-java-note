package exceptions;
//为异常类定义一个接受字符串参数的构造器
/**
 * Created by wangcheng on 2017/8/17.
 */
class MyExceptions extends Exception{
    public MyExceptions(){}
    public MyExceptions(String msg){super(msg);}
}
public class FullConstructors {
    public static void f() throws MyExceptions{
        System.out.println("Throwing MyExceptions from f()");
        throw new MyExceptions();
    }
    public static void g() throws MyExceptions{
        System.out.println("Throwing MyExceptions from g()");
        throw new MyExceptions("Originated in g()");
    }
    public static void main(String[] args){
        try{
            f();
        }catch (MyExceptions e){
            e.printStackTrace(System.out);
        }
        try {
            g();
        }catch (MyExceptions e){
            e.printStackTrace(System.out);
        }
    }
}
