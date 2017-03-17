/**
 * Created by wangcheng on 2017/3/14.
 */
class Component11{
    Component11(byte b){
        System.out.println("Component11(byte)");
    }
}
class Component12{
    Component12(short s){
        System.out.println("Component12(short)");
    }
}
class Component13{
    Component13(int i){
        System.out.println("Component13(int i)");
    }
}
class Root1{
    Component11 c1;
    Component12 c2;
    Component13 c3;
    Root1(float f){
        c1 = new Component11((byte)0);
        c2 = new Component12((short)0);
        c3 = new Component13(0);
        System.out.println("Root(float)");
    }
}
public class Ex10 extends Root1{
    Component11 c1ex;
    Component12 c2ex;
    Component13 c3ex;
    Ex10(double d){
        super(2.78f);
        c1ex = new Component11((byte)1);
        c2ex = new Component12((short)1);
        c3ex = new Component13(1);
        System.out.println("Ex10(double)");
    }
    public static void main(String[] args){
        Ex10 e = new Ex10(2.78);
    }
}
