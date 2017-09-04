package strings;

/**
 * Created by wangcheng  on 2017/8/29.
 */
import java.util.regex.*;
public class ReFlags {
    public static void main(String[] args){
        Pattern p = Pattern.compile("^java",Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
        Matcher m = p.matcher(
                "java has regex\nJava has regex\n"+
                        "JAVA has pretty good regular expressions\n" +
                        "Regular expressions are in java"
        );
        while (m.find()){
            System.out.println(m.group());
        }
    }
}