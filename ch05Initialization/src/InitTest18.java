import java.util.Arrays;
import java.util.Random;

/**
 * Created by wangcheng on 2017/3/2.
 */
class InitTest{
    InitTest(String s){
        System.out.println("InitTest()");
        System.out.println(s);
    }
}
public class InitTest18{
    public static void main(String[] args){
        InitTest[] a = new InitTest[5];
        for(int i=0;i<a.length;i++){
            a[i] = new InitTest(Integer.toString(i));
        }
    }
}