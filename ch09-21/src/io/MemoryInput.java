package io;

/**
 * Created by wangcheng  on 2017/12/6.
 */
import java.io.*;
public class MemoryInput {
    public static void main(String[] args) throws IOException{
        StringReader in = new StringReader(BufferedInputFile.read("src/io/BufferedInputFile.java"));
        int c;
        while ((c=in.read()) != -1)
            System.out.println((char)c);
    }
}
