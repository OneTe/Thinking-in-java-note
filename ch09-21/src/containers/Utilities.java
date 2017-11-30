package containers;

/**
 * Created by wangcheng  on 2017/11/30.
 */
import java.util.*;

public class Utilities {
    static List<String> list = Arrays.asList(
            "one Two three Four five six one".split(" ")
    );
    public static void main(String[] args){
        System.out.println(list);
        System.out.println("'list' disjoint (Four)?: " +
        Collections.disjoint(list,Collections.singletonList("Four")));
    }
}
