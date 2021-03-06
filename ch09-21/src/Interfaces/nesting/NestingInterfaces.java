package Interfaces.nesting;
//嵌套接口
/**
 * Created by wangcheng on 2017/5/16.
 */
class A {
    interface B {
        void f();
    }
    public class BImp implements B {
        public void f() {
        }
    }
    public class BImp2 implements B {
        public void f() {
        }
    }
    public interface C {
        void f();
    }
    class CImp implements C{
        public void f(){}
    }
    private class CImp2 implements C{
        public void f(){}
    }
    private interface D{
        void f();
    }
    private class DImp implements D{
        public void f(){}
    }
    public class DImp2 implements D{
        public void f(){}
    }
    public D getD(){return new DImp2();}
    private D dRef;
    public void receiveD(D d){
        dRef = d;
        dRef.f();
    }
}
interface E{
    interface G{
        void f();
    }
    public interface H{
        void f();
    }
    void g();
    //private interface I{} //cannot be private within an interface
}

public class NestingInterfaces {
    public class BImp implements A.B{
        public void f(){}
    }
    class CImp implements A.C{
        public void f(){}
    }
    class EImp implements E{
        public void g(){}
    }
    class EGImp implements E.G{
        public void f(){}
    }
    class EGImp2 implements E{
        public void g(){}
        class EG implements E.G{
            public void f(){}
        }
    }
    public static void main(String[] args){
        A a = new A();
        //cannot access A.D
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}