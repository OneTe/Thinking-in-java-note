package innerclasses;

// TIJ4 Chapter Innerclasses, Exercise 5, page 352
/* Create a class with an inner class. In a separate class, make an
* instance of the inner class.
*/
/**
 * Created by wangcheng on 2017/5/25.
 */
class Outer{
    class Inner{
        Inner(){System.out.println("Outer.Inner()");}
    }
}
public class OtherOuter {
    public static void main(String[] args){
        Outer o = new Outer();
        Outer.Inner oi = o.new Inner();
    }
}
