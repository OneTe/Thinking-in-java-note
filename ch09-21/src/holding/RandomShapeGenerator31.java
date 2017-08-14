package holding;

import java.util.*;
import holding.shape.*;
// TIJ4 Chapter Holding, Exercise 31, page 434
/* Modify polymorphism/shape/RandomShapeGenerator.java to make it
* Iterable. You'll need to add a constructor that takes the number of
* elements that you want the iterator to produce before stopping. Verify
* that it works.
*/
/**
 * Created by wangcheng on 2017/8/14.
 */
public class RandomShapeGenerator31 implements Iterable<Shape>{
    private Random rand = new Random();
    public Shape make(){
        switch(rand.nextInt(3)){
            default:
            case 0:return new Circle();
            case 1:return new Square();
            case 2:return new Triangle();
        }
    }
    private Shape[] shapes;
    RandomShapeGenerator31(int n){
        shapes = new Shape[n];
        for(int i = 0;i<n;i++){
            shapes[i] = make();
        }
    }
    public Iterator<Shape> iterator(){
        return new Iterator<Shape>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < shapes.length;
            }

            @Override
            public Shape next() {
                return shapes[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args){
        RandomShapeGenerator31 rsg = new RandomShapeGenerator31(20);
        for(Shape s : rsg){
            System.out.println(s);
            s.draw();
        }
    }
}
