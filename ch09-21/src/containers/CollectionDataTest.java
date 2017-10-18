package containers;

/**
 * Created by wangcheng  on 2017/10/17.
 */
import java.util.*;
import net.mindview.util.*;

class Government implements Generator<String>{
    String[] foundation = ("strange women lying in ponds " +
            "distributing swords is no basis for a system of " +
            "government").split(" ");
    private int index;
    public String next(){return foundation[index++];}
}
public class CollectionDataTest {
    public static void main(String[] args){
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(),15));
        set.addAll(CollectionData.list(new Government(),15));
        System.out.println(set);
    }
}
