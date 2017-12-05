package io;
//Use ProcessFile to find all the java source-code files in a
//particular directory subtree that have been modified after a
//particular date
/**
 * Created by wangcheng  on 2017/12/5.
 */
import java.io.*;
import java.text.*;
import java.util.*;

import net.mindview.util.*;

public class ProcessFiles6 {
    public static void main(String[] argss){
        String[] args = {"src/","17-11-3"};
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,Locale.CHINA);
        System.out.println(df.format(new Date()));
        if(args.length != 2){
            System.err.println("Usage: java ProcessFiles6 path date");
            return;
        }
        long tmp = 0;
        try {
            df.setLenient(false);
            tmp = df.parse(args[1]).getTime();
        }catch (ParseException e){
            e.printStackTrace();
            return;
        }
        final long modTime = tmp;
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                if(modTime < file.lastModified())
                    System.out.println(file);
            }
        },"java").start(new String[]{args[0]});
    }
}
