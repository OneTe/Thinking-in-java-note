package containers;
//Demonstrates the "fail-fast" behavior
/**
 * Created by wangcheng  on 2017/11/30.
 */
import java.util.*;

public class FailFast {
    public static void main(String[] args){
        Collection<String> c = new ArrayList<String>();
        Iterator<String> it = c.iterator();
        c.add("An object");
        try {
            String s = it.next();
        }catch (ConcurrentModificationException e){
            System.out.println(e);
        }
    }
}
