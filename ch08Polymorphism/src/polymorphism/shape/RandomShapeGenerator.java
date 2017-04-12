package polymorphism.shape;

import java.util.Random;

/**
 * Created by wangcheng on 2017/4/12.
 */
public class RandomShapeGenerator { //是一种工厂
    private Random rand = new Random(47);
    public Shape next(){
        switch(rand.nextInt(3)){
            default:
            case 0:return new Circle();
            case 1:return new Square();
            case 2:return new Triangle();
        }
    }
}
