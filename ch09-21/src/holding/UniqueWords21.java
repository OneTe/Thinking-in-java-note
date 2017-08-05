package holding;

/**
 * Created by wangcheng on 2017/8/4.
 */
import java.util.*;

public class UniqueWords21 {
    public static void main(String[] args){
        List<String> words = new ArrayList<>(new TextFile("src/holding/SetOperations.java","\\W+"));
        //System.out.println(words);
        Map<String,Integer> map = new TreeMap<>();
        for(String s : words){
            Integer count = map.get(s);
            map.put(s, count == null?1:count + 1);
        }
        System.out.println(map);
    }
}