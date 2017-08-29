package strings;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
/**
 * Created by wangcheng  on 2017/8/29.
 */
public class Groups12 {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";
    public static void main(String[] args){
        Matcher m = Pattern.compile("(^[a-z]|\\s+[a-z])\\w+")
                .matcher(POEM);
        Set<String> words = new TreeSet<>();
        while (m.find()){
                //System.out.print("[" + m.group() + "]");
                words.add(m.group());
        }
        System.out.println(words);
    }
}
