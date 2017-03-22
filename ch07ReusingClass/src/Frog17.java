/**
 * Created by wangcheng on 2017/3/22.
 */
class Amphibian17{
    protected void swim(){
        System.out.println("Amphibian swim()");
    }
    protected void speak(){
        System.out.println("Amphibian speak()");
    }
    void eat(){
        System.out.println("Amphibian eat()");
    }
    static void grow(Amphibian17 a){
        System.out.println("Amphibian grow()");
        a.eat();
    }
}
public class Frog17 extends Amphibian17{
    @Override protected void swim(){
        System.out.println("Frog swim()");
    }
    @Override protected void speak(){
        System.out.println("Frog speak()");
    }
    @Override void eat(){
        System.out.println("Frog eat()");
    }
    static void grow(Amphibian17 a){
        System.out.println("Frog grow()");
        a.eat();
    }
    public static void main(String[] args){
        Frog17 f= new Frog17();
        f.swim();
        f.speak();
        f.eat();
        // upcast Frog17 to Amphibian argument:
        f.grow(f);
        // upcast Frog17 to Amphibian and call Amphibian method:
        Amphibian17.grow(f);
    }
}
