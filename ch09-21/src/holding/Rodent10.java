package holding;
// TIJ4 Chapter Holding, Exercise 10, page 409
/* Change Exercise 9 in the Polymorphism chapter to use an ArrayList to
* hold the Rodents and an Iterator to move through the sequence of
* Rodents.
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangcheng on 2017/8/1.
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
public class Rodent10 {
    public static void main(String[] args){
        List<Rodent> rd = new ArrayList<>();
        rd.add(new Rodent());
        rd.add(new Mouse());
        rd.add(new Rat());
        rd.add(new Squirrel());
        Iterator<Rodent> iterator = rd.iterator();
        while (iterator.hasNext()){
            Rodent x = iterator.next();
            System.out.println(x);
            x.eat();
            x.run();
            x.sleep();
        }
    }
}