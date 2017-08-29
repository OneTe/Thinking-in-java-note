package strings;
//使用reset(),可以将现有的Matcher对象应用于一个新的字符序列
/**
 * Created by wangcheng  on 2017/8/29.
 */
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.regex.*;
public class Resetting {
    public static void main(String[] args) throws Exception{
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while (m.find()){
            System.out.print(m.group() + " ");
        }
        System.out.println();
        m.reset("fix the rig with rags");
        while (m.find()){
            System.out.print(m.group() + " ");
        }
    }
}
