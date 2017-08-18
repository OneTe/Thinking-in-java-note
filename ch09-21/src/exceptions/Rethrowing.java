package exceptions;
//Demonstrating fillInStackTrace()
//重新抛出异常。如果只是把当前异常对象重新抛出，那么printStackTrace()方法显示的将是原来异常抛出点
//的调用栈信息，而并非重新抛出点的信息。要更新这个信息，可以调用调用fillInStackTrace()方法，这将返回一个Throwable对象，
//它是通过把当前调用栈信息填入原来那个异常对象而建立的
/**
 * Created by wangcheng on 2017/8/18.
 */
public class Rethrowing {
    public static void f() throws Exception{
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()");
    }
    public static void g() throws Exception{
        try {
            f();
        }catch (Exception e){
            System.out.println("Inside g(),e.printStackTrace()");
            e.printStackTrace();
            throw e;
        }
    }
    public static void h() throws Exception{
        try {
            f();
        }catch (Exception e){
            System.out.println("Inside h(),e.printStackTrace()");
            e.printStackTrace(System.out);
            //这里重新抛出了异常，调用fillInStackTrace，这一行就成新异常的发生地了
            throw (Exception)e.fillInStackTrace();
        }
    }
    public static void main(String[] args){
        try {
            g();
        }catch (Exception e){
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        try {
            h();
        }catch(Exception e){
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
