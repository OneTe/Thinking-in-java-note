package Interfaces.rodent;

/**
 * Created by wangcheng on 2017/4/20.
 */
abstract class Rodent{
    private String name  = "Rodent";
    abstract protected void eat();
    abstract protected void run();
    abstract protected void sleep();
    abstract public String toString();

}
class Mouse extends Rodent{
    private String name = "Mouse";
    protected void eat(){ System.out.println("Mouse.eat()");}
    protected void run(){ System.out.println("Mouse.run()");}
    protected void sleep(){ System.out.println("Mouse.sleep()");}
    public String toString(){ return name;}
}
class Rat extends Rodent{
    private String name = "Rat";
    protected void eat(){ System.out.println("Rat.eat()");}
    protected void run(){ System.out.println("Rat.run()");}
    protected void sleep(){ System.out.println("Rat.sleep()");}
    public String toString(){ return name;}
}
class Squirrel extends Rodent{
    private String name = "Squirrel";
    protected void eat(){ System.out.println("Squirrel.eat()");}
    protected void run(){ System.out.println("Squirrel.run()");}
    protected void sleep(){ System.out.println("Squirrel.sleep()");}
    public String toString(){ return name;}
}
public class Rodent1 {
    private static RandomRodentGenerator1 gen = new RandomRodentGenerator1();
    public static void main(String[] args){
        //Error: cannot instantiate abstract class:
        //Rodent r= new Rodent();
        // But OK to create array to be downcast to derived objects:
        Rodent[] rodents = new Rodent[10];
        for(Rodent r:rodents){
            r= gen.next();
            System.out.println(r + ": ");
            r.eat();
            r.run();
            r.sleep();
        }
    }
}
