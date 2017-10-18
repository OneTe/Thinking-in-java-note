package containers;
//The Collections.fill() && Collections.nCopies() methods
//fill()只能替换已经在list中存在的元素，而不能添加新元素
/**
 * Created by wangcheng  on 2017/10/17.
 */
import java.util.*;

class StringAddress{
    private String s;
    public StringAddress(String s){this.s = s;}

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
public class FillingLists {
    public static void main(String[] args){
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4,new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list,new StringAddress("World!"));
        System.out.println(list);
    }
}
