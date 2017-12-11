package io;
//Simple use of Externalizable & a pitfall
//恢复b1后，会调用Blip1默认构造器，这与恢复一个Serializable对象不同。对于Serializable对象，
//对象完全以它存储的二进制位为基础来构造，而不用调用构造器
//对于一个Externalizable对象，所有普通的默认构造器都会被调用，然后再调用readExternal()
import java.io.*;

/**
 * Created by wangcheng  on 2017/12/11.
 */
class Blip1 implements Externalizable {
    public Blip1(){
        System.out.println("Blip1 Constructor");
    }
    public void writeExternal(ObjectOutput out) throws IOException{
        System.out.println("Blip1.writeExternal");
    }
    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException{
        System.out.println("Blip1.readExternal");
    }
}
class Blip2 implements Externalizable{
    Blip2(){
        System.out.println("Blip2 Constructor");
    }
    public void writeExternal(ObjectOutput out) throws IOException{
        System.out.println("Blip2.writeExternal");
    }
    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException{
        System.out.println("Blip2.readExternal");
    }
}
public class Blips {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        System.out.println("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("src/io/blips.out"));
        System.out.println("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        //Now get them back
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/io/blips.out"));
        System.out.println("Recovering b1:");
        b1 = (Blip1)in.readObject();
        // Throws an exception:(Blip2's constructor is not public)
//        System.out.println("Recovering b2:");
//        b2 = (Blip2)in.readObject();
    }
}
