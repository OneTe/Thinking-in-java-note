package containers;
//Things you can do with all Collections.
/**
 * Created by wangcheng  on 2017/11/8.
 */
import java.util.*;
import net.mindview.util.*;

public class CollectionMethods {
    public static void main(String[] args){
        Collection<String> c = new ArrayList<String>();
        c.addAll(Countries.names(6));
        c.add("ten");
        System.out.println(c);
        Object[] array = c.toArray();
        String[] str = c.toArray(new String[0]);
        System.out.println("Collections.max(c): " + Collections.max(c));
        System.out.println("Collections.min(c): " + Collections.min(c));
        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        System.out.println(c);
    }
}
