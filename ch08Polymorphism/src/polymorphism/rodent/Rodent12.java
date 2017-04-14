package polymorphism.rodent;
// TIJ4 Chapter Polymorphism, Exercise 12, page 298
/* Modify exercise 9 so that it demonstrates the order of initialization of the
* base classes and derived classes. Now add member objects to both the base and
* derived classes, and show the order in which their initialization occurs during
* construction.
*/
/**
 * Created by wangcheng on 2017/4/14.
 */
class Characteristic{
    private String s;
    Characteristic(String s){
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }
}
class Description{
    private String s;
    Description(String s){
        this.s = s;
        System.out.println("Creating Description " + s);
    }
}
class RodentO{
    private String name = "Rodent";
    private Characteristic c = new Characteristic("has tail");
    private Description d = new Description("small mammal");
    RodentO() { System.out.println("Rodent()"); }
    protected void eat() { System.out.println("Rodent.eat()"); }
    protected void run() { System.out.println("Rodent.run()"); }
    protected void sleep() { System.out.println("Rodent.sleep()"); }
    public String toString() { return name; }
}
class MouseO extends RodentO{
    private String name = "Mouse";
    private Characteristic c = new Characteristic("likes cheese");
    private Description d = new Description("nocturnal");
    MouseO(){System.out.println("Mouse"); }
    protected void eat(){ System.out.println("Mouse.eat()");}
    protected void run(){ System.out.println("Mouse.run()");}
    protected void sleep(){ System.out.println("Mouse.sleep()");}
    public String toString(){ return name; }
}
class RatO extends RodentO{
    private String name = "Rat";
    private Characteristic c = new Characteristic("larger");
    private Description d = new Description("black");
    RatO(){ System.out.println("Rat");}
    protected void eat(){ System.out.println("Rat.eat()"); }
    protected void run(){ System.out.println("Rat.run()");}
    protected void sleep(){ System.out.println("Rat.sleep()");}
    public String toString(){ return name; }
}
class SquirrelO extends RodentO{
    private String name = "Squirrel";
    private Characteristic c = new Characteristic("climbs trees");
    private Description d = new Description("likes nuts");
    SquirrelO(){ System.out.println("Squirrel");}
    protected void eat(){ System.out.println("Squirrel.eat()");}
    protected void run(){ System.out.println("Squirrel.run()");}
    protected void sleep(){ System.out.println("Squirrel.sleep()");}
    public String toString(){ return name; }
}
public class Rodent12 {
    private static RandomRodentGenerator gen = new RandomRodentGenerator();
    public static void main(String[] args){
        RodentO[] rodents = new RodentO[10];

//        for(int i =0; i<rodents.length;i++){
//            rodents[i] = gen.next1();
//        }
        for(RodentO r:rodents){
            r = gen.next1();
            System.out.println(r);
        }
    }
}
