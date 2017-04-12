
/**
 * Created by wangcheng on 2017/4/12.
 */
class Shapes {
    public void printSometing(){
        System.out.println("Shapes.printSometing()");
    }
}
class Circle extends Shapes{
    public void printSometing(){
        System.out.println("Circle.printSometing()");
    }

}

public class Ex3{
    public static void main(String[] args){
        Shapes sp = new Circle();
        sp.printSometing();
    }
}

