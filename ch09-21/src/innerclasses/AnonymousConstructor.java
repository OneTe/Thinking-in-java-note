package innerclasses;
//creating a constructor for an anonymous inner class
/**
 * Created by wangcheng on 2017/6/15.
 */
abstract class Base{
    public Base(int i){
        System.out.println("Base constructor.i=" + i);
    }
    public abstract void f();
}
public class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
            }

            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
//相当于下面这种形式的简化
//public class AnonymousConstructor{
//    public static class InnerBase extends Base{
//        public InnerBase(int i){
//            super(i);
//            System.out.println("Inside instance initializer");
//        }
//        public void f(){System.out.println("In anonymous f()");}
//    }
//    public static Base getBase(int i){
//        return new InnerBase(i);
//    }
//    public static void main(String[] args){
//        Base base = getBase(47);
//        base.f();
//    }
//}
