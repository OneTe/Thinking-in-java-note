package containers;
//TreeMap
/**
 * Created by wangcheng  on 2017/11/14.
 */
import java.util.*;
import net.mindview.util.*;

public class SortedMapDemo {
    public static void main(String[] args){
        TreeMap<Integer,String> sortedMap =
                new TreeMap<>(new CountingMapData(10));
        System.out.println(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        System.out.println(low);
        System.out.println(high);
        Iterator<Integer> it = sortedMap.keySet().iterator();
        for(int i = 0;i < 6;i++){
            if(i == 3) low = it.next();
            if(i == 6) high = it.next();
            else it.next();
        }
        System.out.println(low);
        System.out.println(high);
        System.out.println(sortedMap.subMap(low,high));
        System.out.println(sortedMap.headMap(high));
    }
}
