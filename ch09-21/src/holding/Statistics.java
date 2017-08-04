package holding;
//Simple demonstration of HashMap
/**
 * Created by wangcheng on 2017/8/4.
 */
import java.util.*;

public class Statistics {
    public static void main(String[] args){
        Random rand = new Random(47);
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0;i < 10000;i++){
            //produce a number between 0 and 20;
            int r = rand.nextInt(20);

            Integer freq = m.get(r);
            m.put(r,freq == null ? 1 : freq + 1);

//            if(m.containsKey(r)){
//                int j = m.get(r);
//                j++;
//                m.put(r,j);
//            }else {
//                m.put(r,1);
//            }
        }
        System.out.println(m);
    }
}
