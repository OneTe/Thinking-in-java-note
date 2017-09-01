package typeinfo.toys;
//Class 里面包含很多有用的方法
/**
 * Created by wangcheng  on 2017/9/1.
 */
interface HasBatteries{}
interface Waterproof{}
interface Shoots{}


class Toy {
    // With default constructor commented out will be
    // unable to instantiate this Toy, super of FancyToy:
    // Toy() {}
    Toy(int i){}
}
class FancyToy extends Toy
        implements HasBatteries,Waterproof,Shoots{
    FancyToy(){super(1);}
}
public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args){
        Class c =null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        }catch (ClassNotFoundException e){
            System.out.println("Can't found FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face : c.getInterfaces()){
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;
        try{
            obj = up.newInstance();//这里Toy如果没有默认构造器，就没有办法实例化
        }catch (InstantiationException e){
            System.out.println("Cannot instantiate");
            System.exit(1);
        }catch (IllegalAccessException e){
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
