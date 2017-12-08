package io;
//比较适合对单个数据流进行压缩

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by wangcheng  on 2017/12/8.
 */
public class GZIPcompress {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("src/io/GZIPcompress.java"));
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(new FileOutputStream("src/io/test.gz")));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(new GZIPInputStream(new FileInputStream("src/io/test.gz"))));
        String s;
        while ((s = in2.readLine()) != null)
            System.out.println(s);
    }
}
