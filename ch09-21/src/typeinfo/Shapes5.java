package typeinfo;

/**
 * Created by wangcheng  on 2017/9/1.
 */
import java.util.*;
public class Shapes5 {
    public static void rotate(Shape s) {
        if(!(s instanceof Circle))
            System.out.println(s + " rotate");
    }
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );
        for(Shape shape : shapeList)
            rotate(shape);
    }
}
