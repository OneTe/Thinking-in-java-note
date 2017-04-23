package Interfaces;
// TIJ4 Chapter Interfaces, Exercise 2, page 315
// Create a class as abstract without including any abstract methods, and verify
// that you cannot create any instances of that class.
/**
 * Created by wangcheng on 2017/4/20.
 */
abstract class NoabstractMethod{
    void t(){ System.out.println("t()");}
    void g(){ System.out.println("g()");}
}
abstract class NoabstractMethod1{}
class  Go extends NoabstractMethod{
    Go(){System.out.println("Go()");}
}
public class Ex2 {
    public static void main(String[] args){
       // NoabstractMethod n = new NoabstractMethod();
       // NoabstractMethod1 n1 = new NoabstractMethod1();
        Go g= new Go();
    }
}