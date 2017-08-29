package strings;
// TIJ4 Chapter Strings, Exercise 11, page 533
/* Apply the regular expression
*	(?i)((^[aeiou])|(\\s+[aeiou]))\\w+[aeiou]\\b
* 	to
*	Arline ate eight apples and one orange while Anita hadn't any
*/
// (alternate solution) Note double \\ required for \\s+, \\w+ and \\b in compile():

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.regex.*;

/**
 * Created by wangcheng  on 2017/8/29.
 */
public class RegEx11 {
    public static void main(String[] args){
        Pattern p = Pattern.compile("(?i)((^[aeiou])|(\\\\s+[aeiou]))\\\\w+[aeiou]\\\\b");
        Matcher m = p.matcher("Arline ate eight apples and one orange while Anita hadn't any");
        while (m.find()){
            System.out.println("Match \"" + m.group() + "\" at " + m.start());
        }
    }
}
