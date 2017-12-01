package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.regex.Pattern;
import net.mindview.util.*;

/**
 * Created by wangcheng  on 2017/12/1.
 */
public class Ex1 {
    public static void main(String[] args){
        String name = "Map";
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
        for(String dirItem : list) {
           // System.out.println(dirItem);
            String file = "./src/containers/" + dirItem;
            TreeSet<String> ts = new TreeSet<>(new TextFile(file,"\\W+"));
            if(ts.contains(name))
                System.out.println(dirItem);
        }
    }
}
