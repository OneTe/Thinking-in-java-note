package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 23, page 371
/* Create an interface U with three methods. Create a class A with a method that
* produces a reference to a U by building an anonymous inner class. Create a second
* class B that contains an array of U. B should have one method that accepts and
* stores a reference to U in the array, a second method that sets a reference in
* the array (specified by the method argument) to null, and a third method that
* moves through the array and calls the methods in U. In main, create a group of A
* objects and a single B. Fill the B with U references produced by the A objects.
* Use the B to call back into all the A objects. Remove some of the U references
* from the B.
*/
/**
 * Created by wangcheng on 2017/6/30.
 */
interface U{
    void f();
    void g();
    String toString();
}
class A23{
    U toU(){
        return new U() {
            @Override
            public void f() {}
            @Override
            public void g() {}
            @Override
            public String toString() {return "I'm a U!";}
        };
    }
}
class B23{
    private U[] us;
    B23(int i){us = new U[i];}
    void addU(U u,int i){us[i] = u;}
    void eraseU(int i ){us[i] =null;}
    void testU(){
        for(U u:us){
            u.f();
            u.g();
            u.toString();
        }
    }
    void showUs(){
        for(U u:us){
            if(u!=null) System.out.println(u.toString());
            else System.out.println("I'm null");
        }
    }
}
public class Ex23 {
    public static void main(String[] args){
        A23 a0 = new A23();
        A23 a1 = new A23();
        A23 a2 = new A23();
        B23 b = new B23(3);
        b.addU(a0.toU(),0);
        b.addU(a1.toU(),1);
        b.addU(a2.toU(),2);
        b.showUs();
        b.testU();
        b.eraseU(0);
        b.eraseU(1);
        b.showUs();
    }
}
