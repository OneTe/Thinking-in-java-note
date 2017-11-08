package containers;
// TIJ4 Chapter Containers, Exercise 2, page 809
// Produce a Map and a Set containing all the countries that begin
// with 'A'.
//use regex method
/**
 * Created by wangcheng  on 2017/11/8.
 */
import java.util.*;
import java.util.regex.*;
import net.mindview.util.*;

public class Ex2 {
    public static void main(String[] args){
        Map<String,String> hm = new HashMap<String,String>();
        Set<String> hs = hm.keySet();
        Pattern p = Pattern.compile("A[a-zA-Z]*");
        for(int i = 0;i<Countries.DATA.length;i++){
            if(p.matcher(Countries.DATA[i][0]).matches()){
                hm.put(Countries.DATA[i][0],Countries.DATA[i][1]);
            }
        }
        System.out.println(hm);
        System.out.println(hs);
    }
}
