package strings;
//可以用正则表达式指定分界符
/**
 * Created by wangcheng  on 2017/8/29.
 */
import java.util.*;
public class ScannerDelimiter {
    public static void main(String[] args){
        Scanner sc = new Scanner("12, 42, 56, 123, 232");
        sc.useDelimiter("\\s*,\\s*");
        while (sc.hasNextInt()){
            System.out.println(sc.nextInt());
        }
    }
}
