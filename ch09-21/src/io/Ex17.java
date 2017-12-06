package io;

/**
 * Created by wangcheng  on 2017/12/6.
 */
import net.mindview.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ex17 {
    public static void main(String[] args){
        ArrayList<String> as = new TextFile("src/io/Ex17.java","");
        Map<Character,Integer> map = new HashMap<>();
        for(String s: as) {
            int count = 1;
            char c = s.charAt(0);
            if(map.containsKey(c)){
               count+= map.get(c);
               map.put(c,count);
            }else {
                map.put(c,count);
            }
        }
        System.out.println(map.toString());
    }
}
