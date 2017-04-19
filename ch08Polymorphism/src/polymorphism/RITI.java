package polymorphism;
//运行时类型识别（RTTI）
/**
 * Created by wangcheng on 2017/4/19.
 */
class Usefull{
    void f(){System.out.println("f()");}
    void g(){System.out.println("g()");}
}
class MoreUsefull extends Usefull{
    void f(){System.out.println("MoreUsefull.f()");}
    void g(){System.out.println("MoreUsefull.g()");}
    void u(){System.out.println("MoreUsefull.u()");}
}
public class RITI {
    public static void main(String[] args){
    Usefull[] x = {new Usefull(),new MoreUsefull()};
    x[0].f();
    x[1].g();
    //Method not found in Usefull
    //!x[1].u();
        ((MoreUsefull)x[1]).u();//Downcast//RTTI
        //((MoreUsefull)x[0]).u();//Exception thrown
    }
}
