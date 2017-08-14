package holding;
//Anything Iterable works with foreach
//same as ForEachCollections.java

import java.util.Iterator;

/**
 * Created by wangcheng on 2017/8/14.
 */
public class IterableClass implements Iterable<String>{
    protected String[] words = ("And that is how " + "we know the Earth to be banana-shaped.").split(" ");
    public Iterator<String> iterator(){
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args){
        for(String s : new IterableClass()){
            System.out.print(s + " ");
        }
    }
}
