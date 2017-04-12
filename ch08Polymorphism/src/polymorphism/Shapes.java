package polymorphism;

import polymorphism.shape.RandomShapeGenerator;
import polymorphism.shape.Shape;

/**
 * Created by wangcheng on 2017/4/12.
 */
public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    public static void main(String[] args){
        Shape[] s = new Shape[9];
        for(int i = 0;i<s.length;i++){
            s[i] = gen.next();
        }
        for(Shape shp:s){
            shp.draw();
        }
    }
}
