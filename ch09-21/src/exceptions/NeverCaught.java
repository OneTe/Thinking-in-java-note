package exceptions;
//Ignoring RuntimeException
/**
 * Created by wangcheng on 2017/8/23.
 */
public class NeverCaught {
    static void f(){
        throw new RuntimeException("From f()");
    }
    static void g(){
        //如果RuntimeException没有被捕获而直达main(),那么在程序退出前将调用异常的printStackTrace()方法
        f();
    }
    public static void main(String[] args){
        g();
    }
}
