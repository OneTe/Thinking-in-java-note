package io;
//Sample use of Directory utilities
/**
 * Created by wangcheng  on 2017/12/1.
 */
import java.io.*;
import net.mindview.util.*;

public class DirectoryDemo {
    public static void main(String[] args){
        //All directories:
        PPrint.pprint(Directory.walk(".").dirs);
        //All files beginning whit 'T'
        for(File file : Directory.local(".",".*"))
            System.out.println(file);
    }
}
