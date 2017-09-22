package generics;
//使用ArrayList来创建泛型数组
/**
 * Created by wangcheng  on 2017/9/22.
 */
import java.util.*;
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();
    public void add(T item){array.add(item);}
    public T get(int index){return array.get(index);}
}
