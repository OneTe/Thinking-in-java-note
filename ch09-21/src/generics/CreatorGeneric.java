package generics;
//使用模版方法设计模式
/**
 * Created by wangcheng  on 2017/9/21.
 */
abstract class GenericWithCreate<T>{
    final T element;
    GenericWithCreate(){element = create();}
    abstract T create();
}
class X{}

class Creator extends GenericWithCreate<X>{
    X create(){return new X();}
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}
public class CreatorGeneric {
    public static void main(String[] args){
        Creator c = new Creator();
        c.f();
    }
}
