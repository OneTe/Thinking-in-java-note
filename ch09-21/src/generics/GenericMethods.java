package generics;
//要定义泛型方法，只需要将泛型参数列表置于返回值之前
/**
 * Created by wangcheng  on 2017/9/19.
 */
public class GenericMethods {
    public <T> void f(T x){
        System.out.println(x.getClass().getName());
    }
    //Ex9,accept three parameters
    public <T> void g(T x,T y,T z){
        System.out.println(x.getClass().getName() + " " + y.getClass().getName() + " " + z.getClass().getName());
    }
    //Ex10
    public <T> void h(T x,T y,String z){
        System.out.println(x.getClass().getName() + " " + y.getClass().getName() + " " + z.getClass().getName());
    }
    public static void main(String[] args){
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
        gm.g(1,2,3.0);
        gm.h(1.0F,'c',"hah");
    }
}
