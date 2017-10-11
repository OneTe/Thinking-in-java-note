package generics;
// TIJ4 Chapter Generics, Exercise 34, page 709
/* Create a self-bounded generic type that contains an abstract method
* that takes an argument of the generic type parameter and produces a
* return value of the generic type parameter. In a non-abstract method
* of the class, call the abstract method and return its result. Inherit
* from the self-bounded type and test the resulting class.
*/

/**
 * Created by wangcheng  on 2017/10/11.
 */
abstract class SelfBoundedType<T extends SelfBoundedType<T>>{
    abstract T f(T arg);
    T g(T arg){
        System.out.println("g(T arg)");
        return f(arg);
    }
}
class D34 extends SelfBoundedType<D34>{
    D34 f(D34 arg){
        System.out.println("f(D34 arg)");
        return arg;
    }
}
public class Ex34 {
    public static void main(String[] args){
        D34 d = new D34();
        d.f(d).g(d);
    }
}
