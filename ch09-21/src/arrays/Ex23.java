package arrays;

/**
 * Created by wangcheng  on 2017/10/17.
 */
import java.util.*;
import net.mindview.util.*;

public class Ex23 {
    public static void main(String[] args){
        Integer[] ia = new Integer[6];
        Random r = new Random(47);
        for(int i = 0;i<6;i++){
            ia[i] = r.nextInt(99);
        }
        Arrays.sort(ia,Collections.reverseOrder());
        System.out.println(Arrays.toString(ia));
    }
}
