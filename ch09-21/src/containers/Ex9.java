package containers;

/**
 * Created by wangcheng  on 2017/11/9.
 */
import java.util.*;
import net.mindview.util.*;


public class Ex9 {
    public static void main(String[] args){
        Set<String> ts = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for(int i = 0; i <=5; i++) ts.add(new RandomGenerator.String(2).next());
        System.out.println(ts);
    }
}
