package typeinfo.packageaccess;

/**
 * Created by wangcheng  on 2017/9/14.
 */
import typeinfo.interfacea.*;

class C1 implements A1{
    public void f(){System.out.println("public C.f()");}
    public void g(){System.out.println("public C.g()");}
    void u(){System.out.println("package C.u()");}
    protected void v(){System.out.println("protected C.v()");}
    private void w(){System.out.println("private C.w()");}
}
public class HiddenC {
    public static A1 makeA(){return new C1();}
}
