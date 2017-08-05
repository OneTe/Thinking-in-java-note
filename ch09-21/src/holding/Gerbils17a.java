package holding;

/**
 * Created by wangcheng on 2017/8/4.
 */
import java.util.*;
public class Gerbils17a {
    public static void main(String[] args){
        Map<String,Gerbil> map = new HashMap<>();
        map.put("Fuzzy", new Gerbil(0));
        map.put("Spot", new Gerbil(1));
        map.put("Speedy", new Gerbil(2));
        map.put("Dopey", new Gerbil(3));
        map.put("Sleepy", new Gerbil(4));
        map.put("Happy", new Gerbil(5));
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.print(s + " ");
            map.get(s).hop();
        }
    }
}
