package innerclasses;
//生成对外部类对象的引用，可以使用外部类的名字后面紧跟.this，这样在编译期被知晓并检查，没有任何运行时开销
//Qualifying access to the outer-class object.
/**
 * Created by wangcheng on 2017/5/23.
 */
public class DotThis {
    void f(){System.out.println("DotThis.f()");}
    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }
    public Inner inner(){return new Inner();}
    public static void main(){
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
