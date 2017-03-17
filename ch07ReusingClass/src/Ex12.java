/**
 * Created by wangcheng on 2017/3/16.
 */
class ComponentEx121 {
    ComponentEx121() { System.out.println("Component1()"); }
    void dispose(){
        System.out.println("ComponentEx121 dispose");
    }
}

class ComponentEx122 {
    ComponentEx122() { System.out.println("Component2()"); }
    void dispose(){
        System.out.println("ComponentEx122 dispose");
    }
}

class ComponentEx123 {
    ComponentEx123() { System.out.println("Component3()"); }
    void dispose(){
        System.out.println("ComponentEx123 dispose");
    }
}

class RootEx12 {
    ComponentEx121 cEx121root;
    ComponentEx122 cEx122root;
    ComponentEx123 cEx123root;
    RootEx12() { System.out.println("Root()"); }
    void dispose(){
        System.out.println("RootEx12 dispose");
    }
}

public class Ex12 extends RootEx12 {
    ComponentEx121 c1Ex12 =new ComponentEx121();
    ComponentEx122 c2Ex12 =new ComponentEx122();
    ComponentEx123 c3Ex12 =new ComponentEx123();
    Ex12() { System.out.println("Ex9()"); }
    public void dispose(){
        c1Ex12.dispose();
        c2Ex12.dispose();
        c3Ex12.dispose();
        System.out.println("Ex12 dispose");
    }
    public static void main(String[] args) {
        Ex12 s = new Ex12();
        s.dispose();
    }
}
