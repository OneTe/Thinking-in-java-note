package generics;

/**
 * Created by wangcheng  on 2017/9/21.
 */
import java.util.*;

public class FilledListMaker<T> {
    List<T> create(T t,int n){
        List<T> result = new ArrayList<T>();
        for(int i =0;i<n;i++){
            result.add(t);
        }
        return result;
    }
    public static void main(String[] args){
        FilledListMaker<String> fl = new FilledListMaker<>();
        List<String> list = fl.create("Hello",4);
        System.out.println(list);
    }
}
