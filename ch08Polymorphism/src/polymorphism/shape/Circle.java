package polymorphism.shape;

/**
 * Created by wangcheng on 2017/4/12.
 */
public class Circle extends Shape {
    @Override public void draw(){
        System.out.println("Circle.draw()");
    }
    @Override public void erase(){
        System.out.println("Circle.erase()");
    }
}
