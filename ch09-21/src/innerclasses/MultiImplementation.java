package innerclasses;
//如果拥有的是抽象的类或具体类，而不是接口，那就只有使用内部类才能实现多重继承
/**
 * Created by wangcheng on 2017/6/30.
 */
class D{}
abstract class E{}
class Z extends D{
    E makeE(){return new E() {
    };
    }
}
public class MultiImplementation {
    static void takesD(D d){}
    static void takesE(E e){}
    public static void main(String[] args){
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}

//如果不需要解决"多重继承"的问题，自然可以使用其他方式编码，而不需要使用内部类。但是如果使用了内部类，还可以
//获得其他特性：
/*
1) 内部类可以有多个实例，每个实例都有自己的状态信息，并且与外围类对象的信息相互独立
2）在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，多继承同一个类
3）创建内部类对象的时刻并不依赖于外围类对象的创建。
4）内部类并没有令人迷惑的"is-a"关心，它就是一个独立的实体。
 */
