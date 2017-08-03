package innerclasses;

/**
 * Created by wangcheng on 2017/7/4.
 */
public class testHashCode {
    public static void main(String[] args){
       // String str = "139115052";
        String str = "3416451";
        int hashCode = str.hashCode();
        if(hashCode < 0){
            hashCode = -hashCode;
        }
        System.out.println(hashCode);
    }
}
