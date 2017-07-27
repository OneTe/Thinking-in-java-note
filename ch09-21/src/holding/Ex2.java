package holding;

import java.util.*;

/**
 * Created by wangcheng on 2017/7/27.
 */
public class Ex2 {
    public static  void main(String[] args){
        Set<Integer> c = new HashSet<Integer>();
        for(int i = 0; i < 5; i++){
            c.add(i);
        }
        for(Integer i : c){
            System.out.println(i+ " ");
        }
    }
}
