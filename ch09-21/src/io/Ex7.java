package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by wangcheng  on 2017/12/6.
 */
public class Ex7 {
    public static void read(String filename) throws IOException {
        LinkedList<String> ls = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new FileReader(filename));
        String s;
        while ((s = bf.readLine()) != null)
            ls.addFirst(s);
        while (!ls.isEmpty()) {
            System.out.println(ls.removeFirst());
        }
    }
    public static void main(String[] args) throws IOException{
        Ex7.read("src/io/Ex7.java");
    }
}
