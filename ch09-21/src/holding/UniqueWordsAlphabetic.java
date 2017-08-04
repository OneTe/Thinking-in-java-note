package holding;
//producing an alphabetic listing
/**
 * Created by wangcheng on 2017/8/4.
 */
import java.util.*;
public class UniqueWordsAlphabetic {
    public static void main(String[] args){
        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);//按字母排序了
        words.addAll(new TextFile("src/holding/SetOperations.java","\\W+"));
        System.out.println(words);
    }
}
