package strings;
// strings/SplitDemo14.java
// TIJ4 Chapter Strings, Exercise 14, page 541
// Rewrite SplitDemo using String.split().
/**
 * Created by wangcheng  on 2017/8/29.
 */
import java.util.*;

public class SplitDemo14 {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(input.split("!!")));
        // Only do the first three:
        System.out.println(Arrays.toString(input.split("!!", 3)));
    }
}
