// TIJ4 Chapter Polymorphism, Exercise 5, page 286
/* Starting from Exercise 1, add a wheels() method in Cycle, which returns the
* number of wheels. MOdify ride() to call wheels() and verify that polymorphism
* works.
*/
/**
 * Created by wangcheng on 2017/4/7.
 */
class Cycle{
    private String name = "Cycle";
    private int wheels = 0;
    public static void travel(Cycle c){
        System.out.println("Cycle.ride()" + c);
    }
    public int wheels(){
        return wheels;
    }
    public String toString(){
        return this.name;
    }

}
class Unicycle extends Cycle{
    private String name = "Unicycle";
    private int wheels = 1;
    @Override public int wheels(){
        return wheels;
    }
    public String toString() {
        return this.name;
    }
}
class Bicycle extends Cycle{
    private String name = "Bicycle";
    private int wheels = 2;
    @Override public int wheels(){
        return wheels;
    }
    public String toString() {
        return this.name;
    }
}
class Tricycle extends Cycle{
    private String name = "Tricycle";
    private int wheels = 3;
    @Override public int wheels(){
        return wheels;
    }
    public String toString() {
        return this.name;
    }
}
public class Biking {
    public static void ride(Cycle c){
        c.travel(c);
        System.out.println("wheels: " + c.wheels());
    }
    public static void main(String[] args) {
        Cycle c= new Cycle();
        Unicycle uc = new Unicycle();
        Bicycle bc = new Bicycle();
        Tricycle tc = new Tricycle();
        ride(uc);
        ride(bc);
        ride(tc);
    }
}
