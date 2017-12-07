package io;
//Copying a file using channels and buffers
/**
 * Created by wangcheng  on 2017/12/7.
 */
import java.nio.*;
import java.nio.channels.*;
import java.io.*;
public class ChannelCopy {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception{
        FileChannel in = new FileInputStream("src/io/ChannelCopy.java").getChannel();
        FileChannel out = new FileOutputStream("src/io/test.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer)!=-1){
            buffer.flip();//prepare for writing
            out.write(buffer);
            buffer.clear();//prepare for reading
        }
    }
}
