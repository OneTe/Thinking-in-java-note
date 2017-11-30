package containers;
//把hashCode里面的id去掉没问题，因为equals里面判断还不一样
/**
 * Created by wangcheng  on 2017/11/30.
 */
import java.util.*;

public class CountedString27 {
    private static List<String> created =
            new ArrayList<>();
    private String s;
    private int id = 0;
    public CountedString27(String str){
        s = str;
        created.add(s);
        for(String s2 : created){
            if(s2.equals(s))
                id++;
        }
    }
    public String toString(){
        return "String: " + s + " id: " + id +
                " hashCode(): " + hashCode();
    }
    public int hashCode(){
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result;
        return result;
    }
    public boolean equals(Object o) {
        return o instanceof CountedString27 &&
                s.equals(((CountedString27)o).s) &&
                id == ((CountedString27)o).id;
    }
    public static void main(String[] args){
        Map<CountedString27,Integer> map =
                new HashMap<>();
        CountedString27[] cs = new CountedString27[5];
        for(int i = 0;i<cs.length;i++){
            cs[i] = new CountedString27("hi");
            map.put(cs[i],i);
        }
        System.out.println(map);
        System.out.println(cs[1]);
        for(CountedString27 csString : cs){
            System.out.println("Looking up " + csString);
            System.out.println(map.get(csString));
        }
    }
}
