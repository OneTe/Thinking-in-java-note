package innerclasses;
//比较局部内部类及匿名内部类
//可以在代码块内创建内部类，典型的方式是在一个方法体内创建。局部内部类不能有
//访问说明符，它不是外围类的一部分，但是它可以访问当前代码块内的常量，以及外围类的所以成员


//使用局部内部类而不使用匿名内部类的理由是我们需要一个已命名的构造器，或者需要重载构造器，而匿名内部类只能用于实例初始化
//另一个理由是：需要不止一个该内部类的对象。
/**
 * Created by wangcheng on 2017/7/12.
 */
interface Counter{
    int next();
}
public class LocalInnerClass {
    private int count = 0;
    Counter getCounter(final String name){
        //A local inner class
        class LocalCounter implements Counter{
            public LocalCounter(){
                //local inner class can hava a constructor
                System.out.println("LocalCounter()");
            }
            public int next(){
                System.out.println(name);
                return count++;
            }
        }
        return new LocalCounter();
    }
    Counter getCounter2(final String name){
        return new Counter() {
            //Anonymous inner class cannot hava a named constructor,only an instance initializer
            {
                System.out.println("Counter()");
            }
            @Override
            public int next() {
                System.out.println(name);
                return count++;
            }
        };
    }
    public static void main(String[] args){
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Local inner "),
                c2 = lic.getCounter2("Anonymous inner ");
        for(int i = 0; i < 5; i++){
            System.out.println(c1.next());
        }
        for(int i = 0;i < 5; i++){
            System.out.println(c2.next());
        }
    }
}
