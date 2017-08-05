package holding;

/**
 * Created by wangcheng on 2017/8/4.
 */

import java.util.*;
public class Ex18 {
    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        map.put("wangcheng",1);
        map.put("wenchenyuan",2);
        map.put("xiaobo",3);
        map.put("laojiang",4);
        Set<String> sortedKeys = new TreeSet<>(map.keySet());
        System.out.println(sortedKeys);
        Map<String,Integer> sorted = new LinkedHashMap<>();
        for(String s : sortedKeys){
            System.out.print("Adding: " + s + ",");
            sorted.put(s,map.get(s));
        }
        System.out.println();
        System.out.println(sorted);
     }
}
