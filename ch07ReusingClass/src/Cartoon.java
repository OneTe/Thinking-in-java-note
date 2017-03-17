/**
 * Created by wangcheng on 2017/3/14.
 * 构造过程是从基类"向外"扩散，基类在导出类构造器可以访问它之前，就已经完成了初始化
 * 即使不为Cartoon创建构造器，编译器也会合成一个默认的构造器，该构造器将调用基类的构造器
 */
class Art{
    Art(){
        System.out.println("Art Constructor");
    }
}
class Drawing extends Art{
    Drawing(){
        System.out.println("Drawing Constructor");
    }
}
public class Cartoon extends Drawing{
    public Cartoon(){
        System.out.println("Cartoon Constructor");
    }
    public static void main(String[] args){
        Cartoon  c = new Cartoon();
    }
}
