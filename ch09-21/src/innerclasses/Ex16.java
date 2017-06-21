package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 16, page 364
/* Modify the solution to Exercise 18 from the Interfaces chapter to use
* anonymous inner classes.
* (Exercise 18, Interface: Create a Cycle interface, with implementations
* Unicycle, Bicycle and Tricycle. Create factories for each type of Cycle,
* and code that uses these factories.
*/
/**
 * Created by wangcheng on 2017/6/21.
 */
interface Cycle{void ride();}
interface CycleFactory{Cycle getCycle();}
class Unicycle implements Cycle{
    public void ride(){System.out.println("Ride Unicycle()");}
    public static CycleFactory factory =
            new CycleFactory() {
                @Override
                public Cycle getCycle() {
                    return new Unicycle();
                }
            };
}
class Bicycle implements Cycle{
    public void ride(){System.out.println("Ride Bicycle()");}
    public static CycleFactory factory =
            new CycleFactory() {
                @Override
                public Cycle getCycle() {
                    return new Bicycle();
                }
            };
}
class Tricycle implements Cycle{
    public void ride(){System.out.println("Ride Tricycle()");}
    public static CycleFactory factory =
            new CycleFactory() {
                @Override
                public Cycle getCycle() {
                    return new Tricycle();
                }
            };
}
public class Ex16 {
    public static void rideCycle(CycleFactory cf){
        Cycle c = cf.getCycle();
        c.ride();
    }
    public static void main(String[] args){
        rideCycle(Unicycle.factory);
        rideCycle(Bicycle.factory);
        rideCycle(Tricycle.factory);
    }
}

//interface Cycle{
//    void ride();
//}
//interface CycleFactory{
//    Cycle getCycle();
//}
//class Unicycle implements Cycle{
//    public void ride(){System.out.println("Ride Unicycle");}
//}
//class UnicycleFactory implements CycleFactory{
//    public Cycle getCycle(){return new Unicycle();}
//}
//
//class Bicycle implements Cycle{
//    public void ride(){System.out.println("Ride Bicycle");}
//}
//class BicycleFactory implements CycleFactory{
//    public Cycle getCycle(){return new Bicycle();}
//}
//
//class Tricycle implements Cycle{
//    public void ride(){System.out.println("Ride Tricycle");}
//}
//class TricycleFactory implements CycleFactory{
//    public Cycle getCycle(){return new Tricycle();}
//}
//
//public class Cycles18 {
//    public static void rideCycle(CycleFactory cf){
//        Cycle c = cf.getCycle();
//        c.ride();
//    }
//    public static void main(String[] args){
//        rideCycle(new UnicycleFactory());
//        rideCycle(new BicycleFactory());
//        rideCycle(new TricycleFactory());
//    }
//}
