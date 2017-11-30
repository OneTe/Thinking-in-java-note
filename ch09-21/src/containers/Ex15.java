package containers;

import net.mindview.util.TextFile;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by wangcheng  on 2017/11/14.
 */
public class Ex15 {
    public static void main(String[] args){
        String fileName ="src/containers/Ex15.java";
        SlowMap<String,Integer> wordCount = new SlowMap<>();

        ArrayList<String> fl = new TextFile(fileName,"\\W+");
        Iterator la = fl.iterator();
        while (la.hasNext()){
            String s = (String)la.next();
            if(!wordCount.containsKey(s))
                wordCount.put(s,1);
            else {
                int count = wordCount.get(s);
                wordCount.put(s,++count);
            }
        }
        System.out.println(wordCount);
    }
}
