package generics;
//自限定所做的，就是要求在继承关系中，像下面这样使用这个类
//Class A extends SelfBounded<A>{}
/**
 * Created by wangcheng  on 2017/10/11.
 */
class SelfBounded<T extends SelfBounded<T>>{
    T element;
    SelfBounded<T> set(T arg){
        element = arg;
        return this;
    }
    T get(){return element;}
}
class A1 extends SelfBounded<A1>{}
class B1 extends SelfBounded<A1>{}

class C1 extends SelfBounded<C1>{
    C1 setAndGet(C1 arg){set(arg);return get();}
}
class D1{}
//can't do this :
//class E1 extends SelfBounded<D1>{}
//compile error:Type parameter D1 is not within its bound

class F1 extends SelfBounded{}

public class SelfBounding {
    public static void main(String[] args){
        A1 a = new A1();
        a.set(new A1());
        a = a.set(new A1()).get();
        a = a.get();
        C1 c = new C1();
        c = c.setAndGet(new C1());
    }
}
