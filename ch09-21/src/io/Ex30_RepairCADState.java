package io;
//1.在Shape的子类中添加serializeStaticState()及deserializeStaticState()这两个方法
//2.移除ArrayList shapeTypes
//3.在Shape的子类中添加对新的序列化和反序列化还原静态方法的调用

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wangcheng  on 2017/12/11.
 */
abstract class Shape1 implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public Shape1(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }

    public String toString() {
        return getClass() +
                "color[" + getColor() + "] xPos[" + xPos +
                "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape1 randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle1(xVal, yVal, dim);
            case 1:
                return new Square1(xVal, yVal, dim);
            case 2:
                return new Line1(xVal, yVal, dim);
        }
    }
}
class Circle1 extends Shape1 {
    private static int color;
    public static void
    serializeStaticState(ObjectOutputStream os)
            throws IOException { os.writeInt(color); }
    public static void
    deserializeStaticState(ObjectInputStream os)
            throws IOException { color = os.readInt(); }
    public Circle1(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }
    public void setColor(int newColor) { color = newColor; }
    public int getColor() { return color; }
}
class Square1 extends Shape1 {
    private static int color;
    public static void
    serializeStaticState(ObjectOutputStream os)
            throws IOException { os.writeInt(color); }
    public static void
    deserializeStaticState(ObjectInputStream os)
            throws IOException { color = os.readInt(); }
    public Square1(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }
    public void setColor(int newColor) { color = newColor; }
    public int getColor() { return color; }
}
class Line1 extends Shape1 {
    private static int color;

    public static void
    serializeStaticState(ObjectOutputStream os)
            throws IOException {
        os.writeInt(color);
    }

    public static void
    deserializeStaticState(ObjectInputStream os)
            throws IOException {
        color = os.readInt();
    }

    public Line1(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}
public class Ex30_RepairCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        List<Shape1> shapes = new ArrayList<Shape1>();
        // Make some shapes:
        for(int i = 0; i < 10; i++)
            shapes.add(Shape1.randomFactory());
        // Set all the static colors to GREEN:
        for(int i = 0; i < 10; i++)
            ((Shape1)shapes.get(i)).setColor(Shape1.GREEN);
        // Save the state vector:
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("src/io/CADState.out"));
        Circle1.serializeStaticState(out);
        Square1.serializeStaticState(out);
        Line1.serializeStaticState(out);
        out.writeObject(shapes);
        // Display the shapes:
        System.out.println(shapes);
        // Now read the file back in:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("src/io/CADState.out"));
        // Read in the same order they were written:
        Circle1.deserializeStaticState(in);
        Square1.deserializeStaticState(in);
        Line1.deserializeStaticState(in);
        shapes = (List<Shape1>)in.readObject();
        System.out.println(shapes);
    }
}
