package containers;
//Using the Collections.unmodifiable methods.
/**
 * Created by wangcheng  on 2017/11/30.
 */
import java.util.*;
import net.mindview.util.*;

public class ReadOnly {
    static Collection<String> data =
            new ArrayList<String>(Countries.names(6));
    public static void main(String[] args){
        Collection<String> c =
                Collections.unmodifiableCollection(new ArrayList<>(data));
        System.out.println(c);
        //c.add("one");//can't change it
        //other methods
    }
}
