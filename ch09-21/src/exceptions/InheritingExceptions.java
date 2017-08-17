package exceptions;
//Creating your own exceptions
/**
 * Created by wangcheng on 2017/8/17.
 */
class SimpleException extends Exception{}
public class InheritingExceptions {
    public void f() throws SimpleException{
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
    public static void main(String[] args){
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        }catch (SimpleException e){
            System.out.println("Caught it !");
            e.printStackTrace();
        }
    }
}
