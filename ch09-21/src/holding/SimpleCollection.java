package holding;

/**
 * Created by wangcheng on 2017/7/27.
 */
import Interfaces.test.Interface;

import java.util.*;

public class SimpleCollection {
    public static void main(String[] args){
        Collection<Integer> c = new ArrayList<Integer>();
        for(int i = 0;i<10;i++){
            c.add(i);
        }
        for(Integer i : c) {
            System.out.println(i + " ");
        }
    }
}
