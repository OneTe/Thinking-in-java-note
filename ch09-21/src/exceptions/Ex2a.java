package exceptions;
// TIJ4 Chapter Exceptions, Exercise 2, page 452
/* Define an object reference and initialize it to null. Try to call a method
* through this reference. Now wrap the code in a try-catch clause to catch the
* exception.
*/
/**
 * Created by wangcheng on 2017/8/17.
 */
public class Ex2a {
    private static Integer i = null;
    public static void main(String[] args){
        //leads to NullPointerException:
        //System.out.println(i.toString());
        try {
            System.out.println(i.toString());
        }catch (NullPointerException e){
            System.out.println("Caught NullPointException");
            e.printStackTrace();
        }
        try {
            i = 10;
            System.out.println(i.toString());
        }catch (NullPointerException e){
            System.err.println("Caught NullPointException1");
            e.printStackTrace();
        }finally {
            System.out.println("Got through it");
        }
    }
}
