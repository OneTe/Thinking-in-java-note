package io;

/**
 * Created by wangcheng  on 2017/12/7.
 */
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetChannel {
    public static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception{
        //write a file:
        FileChannel fc = new FileOutputStream("src/io/data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        //Add to the end of the file:
        fc = new RandomAccessFile("src/io/data.txt","rw").getChannel();
        fc.position(fc.size());//Move to the end
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
        //Read the file:
        fc = new FileInputStream("src/io/data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            System.out.println((char)buff.get());
    }
}
