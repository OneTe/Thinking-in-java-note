package Interfaces.rodent;

/**
 * Created by wangcheng on 2017/4/21.
 */
interface Rodent0{
    String name  = "Rodent";
    void eat();
    void run();
    void sleep();
    public String toString();
}
class Mouse0 implements Rodent0{
    private String name = "Mouse";
    public void eat(){ System.out.println("Mouse.eat()");}
    public void run(){ System.out.println("Mouse.run()");}
    public void sleep(){ System.out.println("Mouse.sleep()");}
    public String toString(){ return name;}
}
class Rat0 implements Rodent0{
    private String name = "Rat";
    public void eat(){ System.out.println("Rat.eat()");}
    public void run(){ System.out.println("Rat.run()");}
    public void sleep(){ System.out.println("Rat.sleep()");}
    public String toString(){ return name;}
}
class Squirrel0 implements Rodent0{
    private String name = "Squirrel";
    public void eat(){ System.out.println("Squirrel.eat()");}
    public void run(){ System.out.println("Squirrel.run()");}
    public void sleep(){ System.out.println("Squirrel.sleep()");}
    public String toString(){ return name;}
}
public class Rodent7 {
    private static RandomRodentGenerator2 gen = new RandomRodentGenerator2();
    public static void main(String[] args){
        //Error: cannot instantiate abstract class:
        //Rodent r= new Rodent();
        // But OK to create array to be downcast to derived objects:
        Rodent0[] rodents = new Rodent0[10];
        for(Rodent0 r:rodents){
            r= gen.next();
            System.out.println(r + ": ");
            r.eat();
            r.run();
            r.sleep();
        }
    }
}
