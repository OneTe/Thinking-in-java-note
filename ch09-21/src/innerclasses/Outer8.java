package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 8, page 354
/* Determine whether an outer class has access to the private elements of
* its inner class.
*/
/**
 * Created by wangcheng on 2017/6/1.
 */
public class Outer8 {
    class Inner{
        private int ii1 = 1;
        private int ii2 = 2;
        private void showIi2(){System.out.println(ii2);}
        private void hi(){System.out.println("Inner hi");}
    }
    //need to create objects to access private elements of inner
    int oi = new Inner().ii1;
    void showOi(){System.out.println(oi);}
    void showIi2(){new Inner().showIi2();}
    void outerHi(){new Inner().hi();}
    public static void main(String[] args){
        Outer8 out = new Outer8();
        out.showOi();
        out.showIi2();
        out.outerHi();
    }
}
