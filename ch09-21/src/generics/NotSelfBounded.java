package generics;
//自限定限制只能强制作用与继承关系
/**
 * Created by wangcheng  on 2017/10/11.
 */
public class NotSelfBounded<T> {
    T element;
    NotSelfBounded<T> set(T arg){
        element = arg;
        return this;
    }
    T get(){return element;}
}
class A2 extends NotSelfBounded<A2>{}
class B2 extends NotSelfBounded<A2>{}
class C2 extends NotSelfBounded<C2>{
    C2 setAndGet(C2 arg){set(arg);return get();}
}

class D2{}
//可以了
class E2 extends NotSelfBounded<D2>{}