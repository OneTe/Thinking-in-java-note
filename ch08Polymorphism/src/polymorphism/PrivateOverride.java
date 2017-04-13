package polymorphism;

/**
 * Created by wangcheng on 2017/4/13.
 */
public class PrivateOverride {
    //只有非private方法才可以被覆盖
    private void f(){System.out.println("private f()");}
    public static void main(String[] args){
        PrivateOverride po = new PrivateOverride();
        po.f();
    }
}
class Derived extends PrivateOverride{
    public void f(){System.out.println("public f()");}
}