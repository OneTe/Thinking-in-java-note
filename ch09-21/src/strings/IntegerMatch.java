package strings;
// 正则表达式
/**
 * Created by wangcheng  on 2017/8/28.
 */
public class IntegerMatch {
    public static void main(String[] args){
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+911".matches("-?\\d+"));
        System.out.println("+911".matches("(-|\\+)?\\d+"));
    }
}
