/**
 * Created by wangcheng on 2017/3/14.
 */
class Component1 {
    Component1() { System.out.println("Component1()"); }
}

class Component2 {
    Component2() { System.out.println("Component2()"); }
}

class Component3 {
    Component3() { System.out.println("Component3()"); }
}

class Root {
    Component1 c1root;
    Component2 c2root;
    Component3 c3root;
    Root() { System.out.println("Root()"); }
}

public class Ex9 extends Root {
    Component1 c1Ex9;
    Component2 c2Ex9;
    Component3 c3Ex9;
    Ex9() { System.out.println("Ex9()"); }
    public static void main(String[] args) {
        Ex9 s = new Ex9();
    }
}
