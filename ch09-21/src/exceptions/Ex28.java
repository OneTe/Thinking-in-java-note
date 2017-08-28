package exceptions;
// TIJ4 Chapter Exceptions, Exercise 28, page 500
/* Modify Exercise 4 so that the custom exception class inherits from
* RuntimeException, and show that the compiler allows you to leave
* out the try block.
*/
/**
 * Created by wangcheng  on 2017/8/28.
 */
class Exception28 extends RuntimeException{
    private String msg;
    Exception28(String msg){
        super(msg);
        System.out.println("Exception28");
        this.msg = msg;
    }
    protected void showS(){System.out.println("Message from Exception28: " + msg);}
}
public class Ex28 {
    public static void f() throws Exception28{
        System.out.println("f()");
        throw new Exception28("ouch from f()");
    }
    public static void main(String[] args){
        f();
    }
}
