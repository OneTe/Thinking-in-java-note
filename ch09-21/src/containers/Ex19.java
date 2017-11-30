package containers;

import holding.TextFile;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wangcheng  on 2017/11/29.
 */
public class Ex19 {
    public static void main(String[] args){
        String fileName = "src/containers/Ex19.java";
        SimpleHashMap<String,Integer> wordCount = new SimpleHashMap<>();
        ArrayList<String> fl = new TextFile(fileName,"\\W+");
        Iterator ia = fl.iterator();
        while (ia.hasNext()){
            String s = (String)ia.next();
            if(!wordCount.containsKey(s)){
                wordCount.put(s,1);
            }else {
                int count = wordCount.get(s);
                wordCount.put(s,++count);
            }
        }
        System.out.println(wordCount);
    }
}
