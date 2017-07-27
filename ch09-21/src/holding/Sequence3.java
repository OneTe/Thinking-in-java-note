package holding;

import java.util.ArrayList;
// TIJ4 Chapter Holding, Exercise 3, page 396
/* Modify innerclasses/Sequence.java so that you can add any number
* of elements to it.
*/
/**
 * Created by wangcheng on 2017/7/27.
 */
interface Selector{
    boolean end();
    Object current();
    void next();
}
public class Sequence3 {
    private ArrayList<Object> items = new ArrayList<Object>();
   // private int next = 0;
    //public Sequence3(){items = new ArrayList<Object>();}
    public void add(Object x){
           items.add(x);
    }
    private class SequenceSelector implements Selector{
        private int i = 0;
        public boolean end(){return i == items.size();}
        public Object current(){return items.get(i);}
        public void next(){i++;}
    }
    public Selector selector(){return new SequenceSelector();}

    public static void main(String[] args){
        Sequence3 sequence3 = new Sequence3();
        for(int i = 0;i<10;i++){
            sequence3.add(i);
        }
        Selector selector = sequence3.selector();
        while (!selector.end()){
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
