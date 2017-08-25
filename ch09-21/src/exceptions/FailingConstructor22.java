package exceptions;
// TIJ4 Chapter Exceptions, Exercise 22, page 488
/* Create a class called FailingConstructor with a constructor that might fail
* partway through the construction process and throw an exception. In main(),
* write code that properly guards against this failure.
*/
/**
 * Created by wangcheng on 2017/8/25.
 */
public class FailingConstructor22 {
    Integer[] ia = new Integer[2];
    String s;
    FailingConstructor22(String s) throws Exception{
        ia[0] = 0;
        ia[1] = 1;
        ia[2] = 2;
        this.s = s;
    }
    public static void main(String[] args){
        try {
            FailingConstructor22 fc = new FailingConstructor22("hi");
        }catch (Exception e){
            System.out.println("Caught exception in main");
            e.printStackTrace(System.err);
        }finally {

        }
    }
}
