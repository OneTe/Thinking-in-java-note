package typeinfo;
//Sneaking around an interface
/**
 * Created by wangcheng  on 2017/9/14.
 */
import typeinfo.interfacea.*;
class B1 implements typeinfo.interfacea.A1 {
    public void f(){}
    public void g(){}
}
public class InterfaceViolation {
    public static void main(String[] args){
        typeinfo.interfacea.A1 a = new B1();
        a.f();
        //a.g();
        System.out.println(a.getClass().getSimpleName());
        if(a instanceof B1){
            B1 b = (B1)a;
            b.g();
        }
    }
}
