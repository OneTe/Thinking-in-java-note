package typeinfo;
// TIJ4 Chapter Typeinfo, Exercise 3, page 561
/* Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a Shape,
* then downcast it back to a Rhomboid. Try downcasting to a Circle and
* see what happens.'
*/
/**
 * Created by wangcheng  on 2017/9/1.
 */
import java.util.*;
class Rhomboid extends Shape{
    public String toString(){
        return "Rhomboid";
    }
}
public class Shapes3 {
    public static void main(String[] args){
        Shape s = new Rhomboid();
        System.out.println(s);
        System.out.println((Rhomboid)s);
        //System.out.println((Circle)s);
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle(), new Rhomboid()
        );
        // downcasting back to specific shape:
        for(Shape shape : shapeList)
            shape.draw();
        Rhomboid r = new Rhomboid();
        ((Shape)r).draw();
        // inconvertible types:
        // ((Circle)r).draw();
    }
}
