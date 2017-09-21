package generics;
//在InstantiateGenericType.java中，不能生成类型实例不是在编译期捕获的错误（Integer无法生成）
//改为显示工厂，这样在编译期就能得到检查
/**
 * Created by wangcheng  on 2017/9/21.
 */
interface FactoryI<T>{
    T create();
}
class Foo2<T>{
    private T x;
    public <F extends FactoryI<T>> Foo2(F factory){
        x = factory.create();
    }
}
class IntegerFactory implements FactoryI<Integer>{
    public Integer create(){
        return new Integer(0);
    }
}
class Widget{
    public static class Factory implements FactoryI<Widget>{
        public Widget create(){
            return new Widget();
        }
    }
}
public class FactoryConstraint {
    public static void main(String[] args){
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
