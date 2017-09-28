package generics;
//不能创建ArrayList<int>之类的东西
/**
 * Created by wangcheng  on 2017/9/27.
 */
import java.util.*;
public class ListOfInt {
    public static void main(String[] args){
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<5;i++){
            li.add(i);
        }
        for(int i :li){
            System.out.print(i + " ");
        }
    }
}
