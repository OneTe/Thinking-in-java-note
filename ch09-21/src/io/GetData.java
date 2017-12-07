package io;
//Getting different representations from a ByteBuffer
/**
 * Created by wangcheng  on 2017/12/7.
 */
import java.nio.*;

public class GetData {
    private static final int BSIZE = 1024;
    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < bb.limit())
            if(bb.get()!=0)
                System.out.print("nonzero");
        System.out.println("i = " + i);
        bb.rewind();
        bb.asCharBuffer().put("Howdy!");
        //System.out.println(bb.position());
        char c;
        while ((c = bb.getChar())!=0) {
            System.out.println(c + " ");
        }
        System.out.println("position: " + bb.position());
        bb.rewind();
        System.out.println("position: " + bb.position());
        //store and read a short
        bb.asShortBuffer().put((short)471142);
        System.out.println("position: " + bb.position());
        System.out.println(bb.getShort());
        System.out.println("position: " + bb.position());
        bb.rewind();
        //store and read an int:
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());
        System.out.println("position: " + bb.position());
        bb.rewind();

        //store and read a long:
        bb.asLongBuffer().put(99471142);
        System.out.println(bb.getLong());
        System.out.println("position: " + bb.position());
        bb.rewind();

        //store and read a float:
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());
        System.out.println("position: " + bb.position());
        bb.rewind();

        //store and read a double:
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
        System.out.println("position: " + bb.position());
        bb.rewind();
    }
}
