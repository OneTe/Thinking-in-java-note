package holding;

//使用Collections.sort来排序
/**
 * Created by wangcheng on 2017/8/8.
 */
import java.util.*;

public class Ex24a {
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
        Map<String,Integer> mTemp = new LinkedHashMap<>();
        List<String> ls = new LinkedList<>(m.keySet());
        Collections.sort(ls);
        Iterator<String> lsi =ls.iterator();
        while (lsi.hasNext()){
            String s = lsi.next();
            Integer i = m.get(s);
            m.remove(s);
            mTemp.put(s,i);
        }
        //System.out.println("Sorted map: " + mTemp);
        List<String> lst = new LinkedList<>(mTemp.keySet());
        Collections.sort(lst);
        Iterator<String> lsit = lst.iterator();
        while (lsit.hasNext()){
            String s = lsit.next();
            Integer i = mTemp.get(s);
            mTemp.remove(s);
            m.put(s,i);
        }
        mTemp.clear();
        System.out.println("Sorted map: " + m);
    }
}
