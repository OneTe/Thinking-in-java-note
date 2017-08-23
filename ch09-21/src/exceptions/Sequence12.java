package exceptions;
// TIJ4 Chapter Exceptions, Excercise 12, page 471
/* Modify innerclasses/Sequence.java so that it throws an appropriate
* exception if you try to put in too many elements.
*/

/**
 * Created by wangcheng on 2017/8/23.
 */
interface Selector{
    boolean end();
    Object current();
    void next();
}
public class Sequence12 {
    private Object[] items;
    private int index;
    public Sequence12(int size){items = new Object[size];}
    public void add(Object x) throws ArrayIndexOutOfBoundsException{
        if(index == items.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index < items.length){
            items[index++] = x;
        }
    }
    private class SequenceSelector implements Selector{
        private int i = 0;
        public boolean end(){return i==items.length;}
        public Object current(){return items[i];}
        public void next(){if(i<items.length) i++;}
    }
    public Selector selector(){return new SequenceSelector();}
    public static void main(String[] args){
        Sequence12 sequence12 = new Sequence12(10);
        for(int i = 0;i<10;i++){
            sequence12.add(Integer.toString(i));
        }
        Selector  selector = sequence12.selector();
        while (!selector.end()){
            System.out.println(selector.current() + " ");
            selector.next();
        }
        sequence12.add(Integer.toString(10));
    }
}
