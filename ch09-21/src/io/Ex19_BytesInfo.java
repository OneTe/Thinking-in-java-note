package io;
/****************** Exercise 19 *****************
 * Using BinaryFile and a Map<Byte,Integer>, create
 * a program that counts the occurrence of all the
 * different bytes in a file.
 ***********************************************/
/**
 * Created by wangcheng  on 2017/12/6.
 */
import java.util.*;
import java.io.*;
import net.mindview.util.*;

public class Ex19_BytesInfo {
    public static void main(String[] args) throws IOException{
        Map<Byte,Integer> byteIntegerMap = new HashMap<>();
        for(Byte bt : BinaryFile.read("src/io/Ex19_BytesInfo.java")){
            Integer freq = byteIntegerMap.get(bt);
            byteIntegerMap.put(bt,freq==null?1:freq+1);
        }
        List<Byte> keys =
                new ArrayList<>(byteIntegerMap.keySet());
        Collections.sort(keys);
        for(Byte key : keys)
            System.out.println(key + " => " + byteIntegerMap.get(key));
    }
}
