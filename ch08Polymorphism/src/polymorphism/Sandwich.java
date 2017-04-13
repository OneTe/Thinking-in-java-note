package polymorphism;
//可以看出调用顺序：
/**
 * 1.调用基类构造器
 * 2。按声明顺序调用成员的初始化方法
 * 3。调用导出类构造器主体
 */

/**
 * Created by wangcheng on 2017/4/13.
 */
class Meal{
    private String x = printx();
    Meal(){System.out.println("Meal()");}
    static String printx(){
        System.out.println("xxxxxx");
        return "aa";
    }
}
class Bread{
    Bread(){System.out.println("Bread()");}
}
class Cheese{
    Cheese(){ System.out.println("Cheese()");}
}
class Lettuce{
    Lettuce(){System.out.println("Lettuce()");}
}
class Lunch extends Meal{
    Lunch(){System.out.println("Lunch()");}
}
class PortableLunch extends Lunch{
    PortableLunch(){System.out.println("PortableLunch()");}
}
public class Sandwich extends PortableLunch{
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();
    public Sandwich(){System.out.println("Sandwich()");}
    public static void main(String[] args){
        new Sandwich();
    }
}
