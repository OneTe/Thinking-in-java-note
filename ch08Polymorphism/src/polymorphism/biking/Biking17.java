package polymorphism.biking;
// TIJ4 Chapter Polymorphism, Exercise 17, page 310
/* Using the Cycle hierarchy from Exercise 1, add a balance method() to
* Unicycle and Bicycle, but not to Tricycle. Create instances of all three
* types and upcast them to an array of Cycle. Try to call balance() on each
* element of the array an observe the results. Downcast and call balance() and
* observe what happens.
*/
/**
 * Created by wangcheng on 2017/4/19.
 */
class Cycle{
    private String name = "Cycle";
    private int wheels = 0;
    public static void travel(Cycle c){
        System.out.println("Cycle.ride()" + c);
    }
    public String toString(){
        return this.name;
    }

}
class Unicycle extends Cycle{
    private String name = "Unicycle";
    public void balance(){ System.out.println("Unicycle.balance()");}
    public String toString() {
        return this.name;
    }
}
class Bicycle extends Cycle{
    private String name = "Bicycle";
    public void balance(){ System.out.println("Bicycle.balance()");}
    public String toString() {
        return this.name;
    }
}
class Tricycle extends Cycle{
    private String name = "Tricycle";
    public String toString() {
        return this.name;
    }
}
public class Biking17 {
    public static void ride(Cycle c){
        c.travel(c);
    }
    public static void main(String[] args) {
        Cycle[] c = {new Cycle(),new Unicycle(),new Bicycle(),new Tricycle()};
       // c[0].balance(); //Method not found
        //c[1].balance();//Method not found
        //c[2].balance();//Method not found
        //c[3].balance();//Method not found
       // ((Unicycle)c[0]).balance(); //Exception thrown
        ((Unicycle)c[1]).balance();
    }
}