/**
 * Created by wangcheng on 2017/4/7.
 */
class Cycle{
    private String name = "Cycle";
    public static void travel(Cycle c){
        System.out.println("Cycle.ride()" + c);
    }
    public String toString(){
        return this.name;
    }

}
class Unicycle extends Cycle{
    public static void ride(Unicycle c){
        System.out.println("Unicycle.ride()" + c);
    }
}
class Bicycle extends Cycle{
    public static void ride(Bicycle c){
        System.out.println("Bicycle.ride()" + c);
    }
}
class Tricycle extends Cycle{
    public static void ride(Tricycle c){
        System.out.println("Tricycle.ride()" + c);
    }
}
public class Biking {
    public static void ride(Cycle c){
        c.travel(c);
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
