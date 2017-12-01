package io;
//Building the anonymous inner class "in-place"
/**
 * Created by wangcheng  on 2017/12/1.
 */
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList3 {
    public static void main(String[] args){
        File path = new File("./src/containers");
        String[] list;
        list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile("\\w+.java");
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
}
