package exceptions;
// TIJ4 Chapter Exceptions, Exercise 11, page 468
/* Repeat the previous exercise, but inside the catch clause, wrap g()'s
* exception in a RuntimeException.
*/
/**
 * Created by wangcheng on 2017/8/23.
 */
class GException1 extends Exception{
    GException1(String s){super(s);}
}
public class Ex11 {
    static void f(){
        try {
            g();
        }catch (GException1 ge){
            System.out.println("Caught Exception in f try");
            ge.printStackTrace();
            throw new RuntimeException(ge);
        }
    }
    static void g() throws GException1{
        throw new GException1("from g()");
    }
    public static void main(String[] args){
        f();
    }
}
