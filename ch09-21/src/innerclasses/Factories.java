package innerclasses;
//工厂方法使用匿名类，更优雅啦，而且没有任何必要区创建作为工厂的具体类
/**
 * Created by wangcheng on 2017/6/19.
 */
interface Service{
    void method1();
    void method2();
}
interface ServiceFactory{
    Service getService();
}
/*  //这个是不用匿名函数来实现
class Implementation1 implements Service{
    public void method1(){System.out.println("Implementation1 method1");}
    public void method2(){System.out.println("Implementation1 method2");}
}
class Implementation1Factory implements ServiceFactory{
    public Service getService(){return new Implementation1();}
}
class Implementation2 implements Service{
    public void method1(){System.out.println("Implementation2 method1");}
    public void method2(){System.out.println("Implementation2 method2");}
}
class Implementation2Factory implements ServiceFactory{
    public Service getService(){return new Implementation2();}
}
public class Factories{
    public static void serviceConsumer(ServiceFactory fact){
        Service s =fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args){
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }
}
*/
class Implementation1 implements Service{
    private Implementation1(){}
    public void method1(){System.out.println("Implementation1 method1");}
    public void method2(){System.out.println("Implementation1 method2");}
    public static ServiceFactory factory =
            new ServiceFactory() {
                @Override
                public Service getService() {
                    return new Implementation1();
                }
            };
}
class Implementation2 implements Service{
    private Implementation2(){}
    public void method1(){System.out.println("Implementation2 method1");}
    public void method2(){System.out.println("Implementation2 method2");}
    public static ServiceFactory factory=
            new ServiceFactory() {
                @Override
                public Service getService() {
                    return new Implementation2();
                }
            };
}
public class Factories {
    public static void serviceConsumer(ServiceFactory fact){
        Service s = fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args){
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }
}
