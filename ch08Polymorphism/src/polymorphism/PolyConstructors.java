package polymorphism;
//p163,初始化的实际过程：在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的零
/**
 * Created by wangcheng on 2017/4/18.
 */
class Glyph{
    void draw(){System.out.println("Glyph.draw()");}
    Glyph(){
        System.out.println("Glyph() before draw()");
        //编写构造器的一条准则是如果可以的话，避免调用其他方法。。。
        //在构造器内唯一能够安全调用的那些方法是基类中的final方法（也适用于private方法，他们自动属于final方法），这些方法不能被覆盖，就不会出现这个问题了
        draw();
        System.out.println("Glyph() after draw()");
    }
}
class RoundGlyph extends Glyph{
    private int radius = 1;
    private String s = print1();
    RoundGlyph(int r){
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph().radius " + radius);
    }
    void draw(){
        System.out.println("RoundGlyph.draw().radius " + radius);
    }
    String print1(){
        System.out.println("hahaha");
        return "abc";
    }
}
public class PolyConstructors {
    public static void main(String[] args){
        new RoundGlyph(5);
    }
}
