package generics;

/**
 * Created by wangcheng  on 2017/9/21.
 */
import java.util.*;
public class ListMaker<T> {
    List<T> create() {return new ArrayList<T>();}
    public static void main(String[] args){
        ListMaker<String> stringListMaker = new ListMaker<>();
        List<String> stringList = stringListMaker.create();
    }
}
