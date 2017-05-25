package innerclasses;

//要想直接创建内部类的对象，不能去引用外部类的名字DotNew，而是必须使用外部类的对象来创建该内部类的对象
//这也解决了内部类名字作用域的问题,因此你不必声明（也不能声明）dn.new DotNew.Inner()
/**
 * Created by wangcheng on 2017/5/25.
 */
public class DotNew {
    public class Inner{
        public String toString(){return "Super!";}
    }
    public static void main(String[] args){
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
        //System.out.println(dni);
    }
}
