package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 11, page 356
/* Create a private inner class that implements a public interface.
* Write a method that returns a reference to an instance of the private
* inner class, upcast to the interface. Show that the inner class is
* completely hidden by trying to downcast to it.
*/

/**
 * Created by wangcheng on 2017/6/5.
 */
class Test{
    private class Inner implements Ex11Interface {
        public void say(String s) {
            System.out.println(s);
        }
    }

     Ex11Interface f() {
        return new Inner();
    }
}
public class Ex11 {
        public static void main(String[] args) {
            Test x = new Test();
            x.f().say("ss");
            //Error: cannot find symbol: class Inner:
           // ((Inner) x.Test()).say("ero");
        }
    }

