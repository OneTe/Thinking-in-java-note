package io;
//Reconstructing an externalizable object.

import java.io.*;

/**
 * Created by wangcheng  on 2017/12/11.
 */
public class Blip3 implements Externalizable{
    private int i;
    private String s;
    public Blip3(){
        System.out.println("Blip3 Constructor");
    }
    public Blip3(String x,int a){
        System.out.println("Blip3(String x,int a)");
        s = x;
        i = a;
    }

    @Override
    public String toString() {
        return s + i;
    }
    public void writeExternal(ObjectOutput out) throws IOException{
        System.out.println("Blip3.writeExternal");
        //you must do this:
        out.writeObject(s);
        out.writeInt(i);
    }
    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException{
        System.out.println("Blip3.readExternal");
        //you must do this:
        s = (String)in.readObject();
        i = in.readInt();
    }
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        System.out.println("Constructing objects:");
        Blip3 b3 = new Blip3("A string ",47);
        System.out.println(b3);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("src/io/blip3.out"));
        System.out.println("Saving object:");
        o.writeObject(b3);
        o.close();
        //get it back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/io/blip3.out"));
        System.out.println("Recovering b3:");
        b3 = (Blip3)in.readObject();
        System.out.println(b3);
    }
}
