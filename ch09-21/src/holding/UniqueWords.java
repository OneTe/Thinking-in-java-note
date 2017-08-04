package holding;

/**
 * Created by wangcheng on 2017/8/3.
 */
import java.util.*;
public class UniqueWords {
    public static void main(String[] args){
        Set<String> words = new TreeSet<String>(new TextFile("src/holding/SetOperations.java","\\W+"));
        List<String> li = new ArrayList<>(Arrays.asList("abc","jdf","efg"));
        Set<String>  w = new TreeSet<>(li);
        System.out.println(words);
        System.out.println(w);
    }
}
