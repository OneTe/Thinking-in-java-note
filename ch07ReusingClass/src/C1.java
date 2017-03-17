/**
 * Created by wangcheng on 2017/3/14.
 * Ex5,同Cartoon的例子
 */
class A1 {
    A1(){
        System.out.println("A()");
    }
}
class B1 extends A1 {
    B1()
    {
        System.out.println("B()");
    }
}
public class C1 extends A1 {
    B1 b = new B1(); // will then construct another A and then a B
    public static void main(String[] args) {
        C1 c = new C1(); // will construct an A first
    }
}