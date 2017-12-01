package io;
//Ex2

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by wangcheng  on 2017/12/1.
 */
public class SortedDirList2 {
    private String[] fList;
    public SortedDirList2(String p){
        File path = new File(p);
        String[] list;
        list = path.list();
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        fList = list;
    }
    public String[] list(){
        return fList;
    }
    public ArrayList<String> list(String pa){
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(pa);// "\\w+.java"
        for(String dirItem : fList){
             if(pattern.matcher(dirItem).matches())
                 list.add(dirItem);
        }
        return list;
    }
    public static void main(String[] args){
        SortedDirList2 sd = new SortedDirList2("./src/containers");
        for(String dirItem : sd.list())
            System.out.println(dirItem);
    }
}
