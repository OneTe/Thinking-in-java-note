package polymorphism.shape;

/**
 * Created by wangcheng on 2017/4/12.
 */
public class Triangle extends Shape {
    public void draw(){
        System.out.println("Triangle.draw()");
    }
    public void erase(){
        System.out.println("Triangle.erase()");
    }
}
