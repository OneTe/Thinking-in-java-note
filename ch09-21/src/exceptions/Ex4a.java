package exceptions;
// TIJ4 Chapter Exceptions, Exercise 4, page 452
/* Create your own exception class using the extends keyword. Write a
* constructor for this class that takes a String argument and stores it inside
* the object with a String reference. Write a method that displays the stored
* String. Create a try-catch clause to exercise your new exception.
*/
/**
 * Created by wangcheng on 2017/8/17.
 */
class Exception4a extends Exception{
    private String msg;
    public Exception4a(String msg){
        super(msg);
        System.out.println("Exception4a()");
        this.msg = msg;
    }
    protected void showS(){
        System.out.println("Message from Exception4a: " + msg);
    }
}
public class Ex4a {
    public static void f() throws Exception4a{
        System.out.println("f()");
        throw new Exception4a("Ouch from f()");
    }
    public static void main(String[] args){
        try {
            f();
        }catch (Exception4a e){
            System.err.println("Caught Exception4a");
            e.showS();
            e.printStackTrace();
        }
    }
}
