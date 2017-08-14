package holding;
//All Collections work with foreach
/*
之所以能够和foreach一起工作，是因为在java SE5中引入了新的被称为Iterable的接口，该接口包含一个能够产生Iterator的iterator()的方法
并且Iterable接口被foreach用来在序列中移动。因此你创建了任何实现Iterable的类，都可以用于foreach语句中。
 */
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by wangcheng on 2017/8/14.
 */
public class ForEachCollections {
    public static void main(String[] args){
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs,"Take the long way home".split(" "));
        for(String s : cs){
            System.out.println("'" + s + " ");
        }
    }
}
