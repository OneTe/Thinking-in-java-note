/**
 * Created by wangcheng on 2017/3/2.
 * 静态初始化只在必要时才会进行，不如不创建Table对象，也不引用Table.b1,那么静态的Bowl b1永远不会被创建
 * 初始化的顺序是先静态对象，在是"非静态"对象。静态对象初始化后，不会再次被初始化
 */
class Bowl{
    Bowl(int marker){
        System.out.println("Bowl("+marker+")");
    }
    void f1(int marker){
        System.out.println("f1("+marker+")");
    }
}

class Table{
    static Bowl bowl1 = new Bowl(1);
    Table(){
        System.out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int marker){
        System.out.println("f2("+marker+")");
    }
    static Bowl bowl2 = new Bowl(2);
}
class Cupboard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard(){
        System.out.println("Cupboard");
        bowl4.f1(2);
    }
    void f3(int marker){
        System.out.println("f3("+marker+")");
    }
    static Bowl bowl5 = new Bowl(5);
}
public class StaticInitialization{
    public static void main(String[] args){
        System.out.println("Creating new Cupoard() in main");
        new Cupboard();
        System.out.println("Creating new Cupoard in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}