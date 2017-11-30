package containers;

/**
 * Created by wangcheng  on 2017/11/29.
 */
public class StringHashCode {
    public static void main(String[] args){
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
