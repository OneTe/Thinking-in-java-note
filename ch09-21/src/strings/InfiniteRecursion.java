package strings;

/**
 * Created by wangcheng  on 2017/8/28.
 */
import java.util.*;
public class InfiniteRecursion {
//    public String toString(){
//        return super.toString();
//        //return "InfiniteRecursion address: " + this + "\n";
//    }
    public static void main(String[] args){
        List<InfiniteRecursion> v = new ArrayList<>();
        for(int i = 0;i<5;i++){
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}
