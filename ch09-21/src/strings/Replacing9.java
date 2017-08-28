package strings;

/**
 * Created by wangcheng  on 2017/8/28.
 */
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;
public class Replacing9 {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";
    public static void split(String regex){
        //knights.replaceAll(regex,"_");
        System.out.println(knights.replaceAll(regex,"_"));
    }
    public static void main(String[] args){
        split("a|e|i|o|u");
    }
}
