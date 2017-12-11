package io;
//Restoring the state of the pretend CAD system
//要想序列化static值，需要自己手动实现就像Line中serializeStaticState()
//及deserializeStaticState()这两个方法
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by wangcheng  on 2017/12/11.
 */
public class RecoverCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/io/CADstate.out"));
        List<Class<? extends Shape>> shapeTypes =
                (List<Class<? extends Shape>>)in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shapes =(List<Shape>)in.readObject();
        System.out.println(shapes);
    }
}

