package containers;
//Using the Collections.synchronized methods.
/**
 * Created by wangcheng  on 2017/11/30.
 */
import java.util.*;
public class Synchronization {
    public static void main(String[] args){
        Collection<String> c =
                Collections.synchronizedCollection(new ArrayList<String>());
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
    }
}
