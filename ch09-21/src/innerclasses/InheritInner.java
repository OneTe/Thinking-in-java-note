package innerclasses;
//内部类的继承
/**
 * Created by wangcheng on 2017/7/6.
 */
class WithInner{
    class Inner{}
}
public class InheritInner extends WithInner.Inner{
 // !  InheritInner(){}  //won't compile
    InheritInner(WithInner wi){
        //必须在构造其内使用这种语法：enclosingClassReference.super();
        //这样才提供了必要的引用，然后程序才能编译通过！
        wi.super();
    }
    public static void main(String[] args){
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
