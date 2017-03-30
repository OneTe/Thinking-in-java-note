/**
 * Created by wangcheng on 2017/3/30.
 * 继承与初始化
 * 类的代码在初次使用时才加载。这通常是指加载发生于创建类的第一个对象时。但是当访问static域或static方法时，也会发生加载
 * 定义为static的东西只会被初始化一次
 * 下面例子加载顺序：访问Beetle.main()时，加载器开始启动并找出Beetle类的编译代码（在Beetle.class文件中），在对它进行加载过程中，编译器注意
 * 到它有一个基类（由关键字extends得知），于是它继续进行加载其基类，如果该基类还有其自身的基类，那么第二个基类就会被加载，如此类推。接下来，根
 * 基类中的static初始化即会被执行，然后是下一个导出类，以此类推。这种方式很重要，因为导出类的static初始化可能会依赖于基类成员是否被正确初始化。
 * 必要的类被加载完成后，对象就可以被创建了。
 * 首先，对象中所有的基本类型都会被设为默认值，对象引用被设为null---这是通过将对象内存设为二进制零值而一举生成的。然后基类的构造器被调用。
 */
class Insect{
    private int i = 9;
    protected int j;
    Insect(){
        System.out.println("i = " + i + ", j =" + j);
        j =39;
    }
    private static int x1 =
            printInit("static Insect.x1 initialized");
    private int xx =
            printInit("Insect.xx initialized");
    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}
public class Beetle extends Insect{
    private int k = printInit("Beetle.k initialized");
    public Beetle(){
        System.out.println("k= " + k);
        System.out.println("j= " + j);
    }
    private static int x2 =
            printInit("static Beetle.x2 initialized");
    public static void main(String[] args){
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
        //Insect i = new Insect();
    }
}
