package Interfaces;
// TIJ4 Chapter Interfaces, Exercise 4, page 315
/* Create an abstract class with no methods. Derive a class and add a method.
* Create a static method that takes a reference to the base class, downcasts
* it to the derived class, and calls the method. In main(), demonstrate that it
* works. Now put the abstract declaration for the method in the base class, thus
* eliminating the need for the downcast.
*/

/**
 * Created by wangcheng on 2017/4/20.
 */
abstract class Sad{
    //abstract void f();
}
class Son extends Sad{
    protected  void f(){ System.out.println("Son.f()");}
}
public class Ex4 {
    public static void g( Sad s){
        ((Son)s).f();
       // s.f();
    }
    public static void main(String[] args){
        Son s = new Son();
        Ex4.g(s);
    }
}
