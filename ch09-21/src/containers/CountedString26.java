package containers;

/**
 * Created by wangcheng  on 2017/11/30.
 */
import java.util.*;

public class CountedString26 {
    private static List<String> created =
            new ArrayList<>();
    private String s;
    private char c;
    private int id = 0;
    public CountedString26(String str,char c){
        s = str;
        c = c;
        created.add(s);
        for(String s2 : created){
            if(s2.equals(s))
                id++;
        }
    }
    public String toString(){
        return "String: " + s + " id: " + id + " char: " + c +
                " hashCode(): " + hashCode();
    }
    public int hashCode(){
        int result = 17;
        result = 37 * result + s.hashCode() + (int)c;
        result = 37 * result + id;
        return result;
    }
    public boolean equals(Object o) {
        return o instanceof CountedString26 &&
                s.equals(((CountedString26)o).s) &&
                c ==(((CountedString26)o).c) &&
                id == ((CountedString26)o).id;
    }
    public static void main(String[] args){
        Map<CountedString26,Integer> map =
                new HashMap<>();
        CountedString26[] cs = new CountedString26[5];
        for(int i = 0;i<cs.length;i++){
            cs[i] = new CountedString26("hi",'a');
            map.put(cs[i],i);
        }
        System.out.println(map);
        for(CountedString26 csString : cs){
            System.out.println("Looking up " + csString);
            System.out.println(map.get(csString));
        }
    }
}
