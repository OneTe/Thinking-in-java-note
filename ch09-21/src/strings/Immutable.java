package strings;
//String对象是不可变的
/**
 * Created by wangcheng  on 2017/8/28.
 */
public class Immutable {
    public static String upcase(String s){
        return s.toUpperCase();
    }
    public static void main(String[] args){
        String q = "howdy";
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);
    }
}
