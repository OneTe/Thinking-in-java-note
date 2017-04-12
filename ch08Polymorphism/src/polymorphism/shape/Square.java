package polymorphism.shape;

/**
 * Created by wangcheng on 2017/4/12.
 */
public class Square extends Shape {
    public void draw(){
        System.out.println("Square.draw()");
    }
    public void erase(){
        System.out.println("Square.erase()");
    }
}
