package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 1, page 347
/* Write a class named Outer that contains an inner class named Innet.
* Add a method to Outer that returns an object of type Inner. In main(),
* create and initialize a reference to an Inner.
*/
/**
 * Created by wangcheng on 2017/5/19.
 */
public class Outer1 {
    class Inner{
        Inner(){System.out.println("Inner()");}
    }
    Outer1(){System.out.println("Outer1()");}
    Inner makeInner(){
        return new Inner();
    }
    public static void main(String[] args){
        Outer1 o = new Outer1();
        Inner i = o.makeInner();
    }
}
