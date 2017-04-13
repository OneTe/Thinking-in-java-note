package polymorphism;
//任何域访问操作都将有编译器解析，因此不是多态的
//只有普通方法调用可以是多态的
/**
 * Created by wangcheng on 2017/4/13.
 */
class Super{
    public int field = 0;
    public int getField(){return field;}
}
class Sub extends Super{
    //Sub包含了两个称为field的域：它自己的和它从Super处得到的
    public int field = 1;
    public int getField(){return field;}
    public int getSuperField(){return super.field;}
}
public class FieldAccess {
    public static void main(String[] args){
        Super sup = new Sub();
        System.out.println("sup.field = " + sup.field +
        ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field +
                ", sub.getField() = " + sub.getField()+
                ", sub.getSuperField() = " + sub.getSuperField());
    }
}
