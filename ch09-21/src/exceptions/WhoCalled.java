package exceptions;
//Programmatic access to stack trace information
//栈轨迹，getStackTrace()返回一个由栈轨迹中的元素构成的数组，每个元素都表示栈中的一帧
/**
 * Created by wangcheng on 2017/8/18.
 */
public class WhoCalled {
    static void f(){
        //Generate an exception to fill in the stack trace
        try {
            throw new Exception();
        }catch(Exception e){
            for(StackTraceElement ste : e.getStackTrace()){
                System.out.println(ste.getMethodName());
            }
        }
    }
    static void g(){f();}
    static void h(){g();}
    public static void main(String[] args){
        f();
        System.out.println("-------------------");
        g();
        System.out.println("-------------------");
        h();
    }
}
