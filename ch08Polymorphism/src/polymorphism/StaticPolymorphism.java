package polymorphism;
//如果某个方法是静态的，它的行为就不具有多态性
/**
 * Created by wangcheng on 2017/4/13.
 */
class StaticSuper{
    public void StaticSuper(){
        System.out.println("aaa");
    }
    public static String staticGet(){
        return "Base staticGet()";
    }
    public String dynamicGet(){
        return "Base dynamicGet()";
    }
}
class StaticSub extends StaticSuper{
    public static String staticGet(){
        return "Derived staticGet()";
    }
    public String dynamicGet(){
        return "Derived dynamicGet()";
    }
}
public class StaticPolymorphism {
    public static void main(String[] args){
        StaticSuper sup = new StaticSub();
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
}
