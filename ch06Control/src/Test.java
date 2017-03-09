/**
 * Created by wangcheng on 2017/3/9.
 */
import com.xiaomi.migc.ch06.*;
public class Test {
    public static void main(String[] args){
        Print1 p = new Print1();
        Range r = new Range();
        //r.sun();
        int [] first = r.range(10);
        int [] sec = r.range(1,6);
        int [] three= r.range(1,10,3);

        for(int n :first)
            p.print1(n);
        for(int n:sec)
            p.print1(n);
        for(int n:three)
            p.print1(n);
    }
}
