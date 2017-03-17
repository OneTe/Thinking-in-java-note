/**
 * Created by wangcheng on 2017/3/14.
 */
class A {
    A(){ System.out.println("A()");}
}

class B extends A { B(){ System.out.println("B()");} }

class C extends B { C(){ System.out.println("C()");} }

class D extends C {
    D() { System.out.println("D()"); }
    public static D makeD() { return new D(); }
    public static void main(String[] args) {
        D d = new D();
        D d2 = makeD();
    }
}

public class Ex4 extends D {
    Ex4() { System.out.println("E()"); }
    public static void main(String[] args) {
        Ex4 e = new Ex4();
        // test D:
        D.main(args);
    }
}
