package arrays;
//编写自己的Comparator，基于j值
//这算策略设计模式的一个应用实例
/**
 * Created by wangcheng  on 2017/10/17.
 */
import java.util.*;
import net.mindview.util.*;

class CompTypeComparator implements Comparator<CompType>{
    public int compare(CompType o1,CompType o2){
        return (o1.j < o2.j) ? -1 : (o1.j == o2.j)? 0 : 1;
    }
}
public class ComparatorTest {
    public static void main(String[] args){
        CompType[] a = Generated.array(new CompType[12],CompType.generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a,new CompTypeComparator());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}
//Comparable和Comparator区别比较
//Comparable是排序接口，若一个类实现了Comparable接口，就意味着“该类支持排序”。而Comparator是比较器，
//我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。
//Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。
//两种方法各有优劣， 用Comparable 简单， 只要实现Comparable 接口的对象直接就成为一个可以比较的对象，
//但是需要修改源代码。 用Comparator 的好处是不需要修改源代码， 而是另外实现一个比较器，
//当某个自定义的对象需要作比较的时候，把比较器和对象一起传递过去就可以比大小了， 并且在Comparator
//里面用户可以自己实现复杂的可以通用的逻辑，使其可以匹配一些比较简单的对象，那样就可以节省很多重复劳动了。