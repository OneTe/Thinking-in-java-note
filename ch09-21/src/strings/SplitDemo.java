package strings;

/**
 * Created by wangcheng  on 2017/8/29.
 */
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;
import java.util.regex.*;
public class SplitDemo {
    public static void main(String[] args){
        String input =
                "This!!unusual use!!of exclamation!!points";
        String in = "com.xiaomi.migc.sdk.ios.model.pb.AccountRsp.retCod";
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input,3)));
        System.out.println(Arrays.toString(Pattern.compile("\\.").split(in)));
    }
}
