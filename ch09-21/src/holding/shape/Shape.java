package holding.shape;

/**
 * Created by wangcheng on 2017/8/14.
 */
public class Shape {
//    public void draw(){}
//    public void erase(){}
//    public void amend(){System.out.println("Shape.amend()");}
//    public String toString(){return "Shape";}
    public void draw(){System.out.println(this.getClass() + ".draw()");}
    public void erase(){System.out.println(this.getClass() + ".erase()");}
    public void amend(){System.out.println(this.getClass() + ".amend()");}
    public String toString(){return this.getClass().toString();}
}
