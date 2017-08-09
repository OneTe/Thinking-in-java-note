package holding;
// TIJ4 Chapter Holding, Exercise 24, page 423
/* Fill a LinkedHashMap with String keys and objects of your choice.
* Now extract the pairs, sort them based on the keys, and reinsert
* them into the Map.
*/
//这个用了treeset自动排序了，Ex24a用list，然后使用Collections.sort来排序
import java.util.LinkedHashMap;

/**
 * Created by wangcheng on 2017/8/7.
 */
import java.util.*;

public class Ex24 {
    public static void main(String[] args){
        Map<String,Integer> m = new LinkedHashMap<>();
        m.put("ten",10);
        m.put("nine",9);
        m.put("eight",8);
        m.put("seven",7);
        m.put("six",6);
        m.put("five",5);
        m.put("four",4);
        m.put("three",3);
        m.put("two",2);
        m.put("one",1);
        m.put("zero",0);
        System.out.println("Map to sort: " + m);
        //temporary map to hold entrys:
        Map<String,Integer> mTemp = new LinkedHashMap<>();
        //use TreeSet to sort the keySet();
        Set<String> ss = new TreeSet<>(m.keySet());
        //move sorted keys to the temp map:
        Iterator<String> itss = ss.iterator();
        while (itss.hasNext()){
            String s = itss.next();
            Integer i = m.get(s);
            m.remove(s);
            mTemp.put(s,i);
        }
        //get sorted list of temp keys:
        Set<String> ssTemp = new TreeSet<>(mTemp.keySet());
        Iterator<String> itssTemp = ssTemp.iterator();
        while (itssTemp.hasNext()){
            String s = itssTemp.next();
            Integer i = mTemp.get(s);
            mTemp.remove(s);
            m.put(s,i);
        }
        //done with temp:
        mTemp.clear();
        System.out.println("Sorted map: " + m);
    }
}
