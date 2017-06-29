package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 20, page 367
/* Create an interface containing a nested class. Implement this interface and
* create an instance of the nested class.
*/
/**
 * Created by wangcheng on 2017/6/29.
 */
interface In{
    class Nested{
        Nested(){System.out.println("Nested()");}
        public void f(){System.out.println("f()");}
    }
}
public class Ex20 implements In {
    public static void main(String[] args){
        In.Nested n = new In.Nested();
        n.f();
    }
}
