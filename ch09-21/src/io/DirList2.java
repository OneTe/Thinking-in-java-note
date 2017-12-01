package io;
//Uses anonymous inner classes.
/**
 * Created by wangcheng  on 2017/12/1.
 */

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class DirList2 {
    public static FilenameFilter filter(final String regex){
        //Creation of anonymous inner class :
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
    public static void main(String[] args){
        File path = new File("./src/containers");
        String[] list;
        list = path.list(filter("\\w+.java"));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
}
