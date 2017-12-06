package io;

/**
 * Created by wangcheng  on 2017/12/6.
 */
import java.io.*;
import net.mindview.util.*;
public class Ex20_ClassSignatureChecker {
    final static byte[] signature =
            {(byte)202,(byte)254,(byte)186,(byte)190};
    public static void main(String[] args) throws IOException{
        String dir = "/Users/wangcheng/IdeaProjects/TIJk-code/Thinking-in-java-note/ch09-21/out";
        for(File file : Directory.walk(dir,".*\\.class")){
            byte[] bt = BinaryFile.read(file);
            for(int i=0;i<signature.length;i++){
                if(bt[i] != signature[i]){
                    System.out.println(file + " is corrupt!");
                    break;
                }
            }
//            System.out.println(file.getName());
        }
    }
}
