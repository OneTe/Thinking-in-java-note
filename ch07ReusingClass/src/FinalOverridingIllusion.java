/**
 * Created by wangcheng on 2017/3/29.
 * final方法
 * 使用final方法有2个原因，1：出于设计考虑，防止任何继承类修改它的含义，不会被覆盖。2：出于效率（java的早起实现），现在基本不需要使用final
 * 来优化了
 *
 * 在类中所有的private方法都隐式的指定是final的。由于无法调用private方法，所有也就无法覆盖它
 * 可以对private方法添加final修饰词，但是没什么意义啊,这一问题会造成混乱，因为
 * 如果你试图覆盖一个private方法（隐含是final的），似乎是奏效的，而且编译器也不会给出错误的信息
 */
class WithFinals{
    //Identical to "final" alone:
    private final void f(){
        System.out.println("WithFinal.f()");
    }
    //Also automatically "final"
    private void g(){
        System.out.println("WithFinal.g()");
    }
}
class OverridingPrivate extends WithFinals{
     private final void f(){
        System.out.println("OverridingPrivate.f()");
    }
     private void g(){
        System.out.println("OverridingPrivate.g()");
    }
}
class OverridingPrivate2 extends OverridingPrivate{
    public final void f(){
        System.out.println("OverridingPrivate2.f()");
    }
    public void g(){
        System.out.println("OverridingPrivate2.g()");
    }
}
public class FinalOverridingIllusion {
    public static void main(String[] args){
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        OverridingPrivate op = op2;
        //can't call the methods;
        //!op.f();
        //!op.g();
        WithFinals wf = op2;
        //!wf.f();
        //!wf.g();
    }
}
