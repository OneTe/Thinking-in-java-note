package io;

import java.io.*;

/**
 * Created by wangcheng  on 2017/12/11.
 */
class Thing1 implements Serializable{
    private Thing2 next;
    public Thing1(int id){next = new Thing2(id);}

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Thing1(Thing2(");
        result.append(next);
        result.append("))");
        return result.toString();
    }
}
class Thing2 implements Serializable{
    private int id;
    public Thing2(int id){this.id = id;}

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
public class Ex27_ObjectSerialization {
    public static void main(String[] args) throws ClassNotFoundException,IOException{
        Thing1 t1 = new Thing1(1);
        System.out.println("t1 = " + t1);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/io/thing1.out"));
        out.writeObject("Thing1 storage\n");
        out.writeObject(t1);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/io/thing1.out"));
        String s = (String)in.readObject();
        Thing1 t2 = (Thing1)in.readObject();
        System.out.println(s + "t2 = " + t2);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Thing1 storage\n");
        out2.writeObject(t1);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String)in2.readObject();
        Thing1 t3 =(Thing1)in2.readObject();
        System.out.println(s + "t3 = " + t3);
    }
}
