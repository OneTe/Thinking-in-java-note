package containers;

/**
 * Created by wangcheng  on 2017/11/8.
 */
import holding.TextFile;
import sun.plugin.dom.core.Text;

import java.util.*;

public class Ex4 {
    static Collection<String> CollectFromText(String fileName){
        String[] sa = TextFile.read(fileName).split(" ");
        return Arrays.asList(sa);
    }
    static Collection<String> CollectFromText2(String fileName){
        String[] sa = TextFile.read(fileName).split(" ");
        return new TreeSet<String>(new TextFile(fileName,"\\W+"));
    }
    public static void main(String[] args){
        System.out.println(CollectFromText("src/containers/Ex4.java"));
        System.out.println(CollectFromText2("src/containers/Ex4.java"));
    }
}
