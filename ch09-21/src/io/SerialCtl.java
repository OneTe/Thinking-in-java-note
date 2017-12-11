package io;
//Controlling serialization by adding your own
//writeObject() and readObject() methods.
//非transient字段由defaultWriteObject()方法保存
//而transient字段必须在程序中明确保存和恢复
import java.io.*;

/**
 * Created by wangcheng  on 2017/12/11.
 */
public class SerialCtl implements Serializable{
    private String a;
    private transient String b;
    public SerialCtl(String aa,String bb){
        a = "Not transient: " + aa;
        b ="Transient: " + bb;
    }

    @Override
    public String toString() {
        return a + "\n" + b;
    }
    private void writeObject(ObjectOutputStream stream) throws IOException{
        stream.defaultWriteObject();
        stream.writeObject(b);
    }
    private void readObject(ObjectInputStream stream) throws IOException,ClassNotFoundException{
        stream.defaultReadObject();
        b = (String)stream.readObject();
    }
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        SerialCtl sc = new SerialCtl("Test1","Test2");
        System.out.println("Before:\n" + sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);
        //now get it back:
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2 = (SerialCtl)in.readObject();
        System.out.println("After:\n" + sc2);
    }
}
