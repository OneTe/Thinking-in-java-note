package io;

/**
 * Created by wangcheng  on 2017/12/6.
 */
import java.io.*;
public class BufferedInputFile {
    //Throw exceptions to console:
    public static String read(String filename) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine())!=null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException{
        System.out.println(read("src/io/BufferedInputFile.java"));
    }
}