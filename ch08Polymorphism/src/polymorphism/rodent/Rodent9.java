package polymorphism.rodent;
// TIJ4 Chapter Polymorphism, Exercise 9, page 289
/* Create an inheritance hierarchy of Rodent:Mouse, Gerbil, Hamster, etc. In the
* base class, provide methods that are common to all Rodents, and override these
* in the derived classes to perform different behaviors depending on the
* specific type of Rodent. Create an array of Rodent, fill it with different
* specific types of Rodents, and call your base-class methods to see what
* happens.
*/
/**
 * Created by wangcheng on 2017/4/13.
 */
class Rodent{
    private String name = "Rodent";
    protected void eat(){ System.out.println("Rodent.eat()");}
    protected void run(){ System.out.println("Rodent.run()");}
    protected void sleep(){ System.out.println("Rodent.sleep()");}
    public String toString(){ return name; }
}
class Mouse extends Rodent{
    private String name = "Mouse";
    protected void eat(){ System.out.println("Mouse.eat()");}
    protected void run(){ System.out.println("Mouse.run()");}
    protected void sleep(){ System.out.println("Mouse.sleep()");}
    public String toString(){ return name; }
}
class Rat extends Rodent{
    private String name = "Rat";
    protected void eat(){ System.out.println("Rat.eat()");}
    protected void run(){ System.out.println("Rat.run()");}
    protected void sleep(){ System.out.println("Rat.sleep()");}
    public String toString(){ return name; }
}
class Squirrel extends Rodent{
    private String name = "Squirrel";
    protected void eat(){ System.out.println("Squirrel.eat()");}
    protected void run(){ System.out.println("Squirrel.run()");}
    protected void sleep(){ System.out.println("Squirrel.sleep()");}
    public String toString(){ return name; }
}
public class Rodent9 {
    private static RandomRodentGenerator gen = new RandomRodentGenerator();
    public static void main(String[] args){
        Rodent[] rodents = new Rodent[10];
        for(int i = 0;i<rodents.length;i++){
            rodents[i] = gen.next();
        }
        for(Rodent rodent:rodents){
            System.out.println(rodent + ": ");
            rodent.eat();
            rodent.run();
            rodent.sleep();
        }
    }
}
