package typeinfo;

/**
 * Created by wangcheng  on 2017/9/1.
 */
import java.util.*;
class Circle1 extends Shape {
    boolean flag = false;
    public String toString() {
        return (flag ? "H" : "Unh") + "ighlighted " + "Circle";
    }
}

class Square1 extends Shape {
    boolean flag = false;
    public String toString() {
        return (flag ? "H" : "Unh") + "ighlighted " + "Square";
    }
}

class Triangle1 extends Shape {
    boolean flag = false;
    public String toString() {
        return (flag ? "H" : "Unh") + "ighlighted " + "Triangle";
    }
}

public class Shapes6 {
    public static void setFlag(Shape s) {
        if(s instanceof Triangle1)
            ((Triangle1)s).flag = true;
    }
    public static void main(String[] args) {
        // upcasting to Shape:
        List<Shape> shapeList = Arrays.asList(
                new Circle1(), new Square1(), new Triangle1()
        );
        for(Shape shape : shapeList) {
            setFlag(shape);
            System.out.println(shape);
        }
    }
}
