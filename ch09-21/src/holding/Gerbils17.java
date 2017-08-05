package holding;

/**
 * Created by wangcheng on 2017/8/4.
 */
import java.util.*;

public class Gerbils17 {
    public static void main(String[] args){
        Map<String,Gerbil> map = new HashMap<>();
        map.put("Fuzzy",new Gerbil(1));
        map.put("Spot",new Gerbil(2));
        map.put("rong",new Gerbil(3));
        for(String s : map.keySet()){
            System.out.print(s + " ");
            map.get(s).hop();
            System.out.println();
        }
    }
}
