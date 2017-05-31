package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 6, page 353
/* Create an interface with at least one method, in its own package. Create
* a class in a separate package. Add a protected inner class that
* implements the interface. In a third package, inherit from your class and
* inside a method, return an object of the protected inner class, upcasting
* to the interface during the return.
*/
import innerclasses.Ex6Interface.*;
import innerclasses.Ex6Base.*;
/**
 * Created by wangcheng on 2017/5/31.
 */

public class Ex6 extends Ex6Base{
    Ex6Interface getBaseInner(){
        return this.new Ex6BaseInner();
    }
    public static void main(String[] args){
        Ex6 ex =  new Ex6();
        System.out.println(ex.getBaseInner().say());
    }
}