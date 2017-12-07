package io;
//Using transferTo() between channels
/**
 * Created by wangcheng  on 2017/12/7.
 */
import java.nio.channels.*;
import java.io.*;

public class TransferTo {
    public static void main(String[] args) throws Exception{
        FileChannel
                in = new FileInputStream("src/io/ChannelCopy.java").getChannel(),
                out = new FileOutputStream("src/io/test.txt").getChannel();
        in.transferTo(0,in.size(),out);
        //or
        //out.transferFrom(in,0,in.size());
    }
}
