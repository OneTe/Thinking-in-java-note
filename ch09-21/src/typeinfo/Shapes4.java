package typeinfo;

/**
 * Created by wangcheng  on 2017/9/1.
 */
public class Shapes4 {
    public static void main(String[] args){
        Rhomboid r = new Rhomboid();
        Shape s = (Shape)r;
        s.draw();
        // check type before downcast:
        if(s instanceof Circle)
            ((Circle)s).draw();
        else if(!(s instanceof Circle))
            System.out.println("(Shape)r is not a Circle");
    }
}
