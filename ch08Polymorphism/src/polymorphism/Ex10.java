package polymorphism;
// TIJ4 Chapter Polymorphism, Exercise 10, page 290
/* Create a base class with two methods. In the first method, call the second
* method. Inherit a class and override the second method. Create an object of
* the derived class, upcast it to the base type, and call the first method.
* Explain what happens.
*/
/**
 * Created by wangcheng on 2017/4/13.
 */
class TwoMethod{
    public void one(){
        two();
        System.out.println("TwoMethod.one()");
    }
    public void two(){
        System.out.println("TwoMethod.two");
    }
}
class Child extends TwoMethod{
    public void two(){
        System.out.println("Child.two()");
    }
}
public class Ex10 {
    public static void main(String[] args){
        Child t = new Child();
        t.one();
    }
}
