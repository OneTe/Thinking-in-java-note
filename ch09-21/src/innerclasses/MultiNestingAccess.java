package innerclasses;
//Nested classes can access all members of all
//levels of the classes they are nested within
//从多重嵌套类中访问外部类的成员
/**
 * Created by wangcheng on 2017/6/29.
 */
class MNA{
    private void f(){}
    class A{
        private void g(){}
        public class B{
            void h(){
                g();
                f();
            }
        }
    }
}
public class MultiNestingAccess {
    public static void main(String[] args){
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
