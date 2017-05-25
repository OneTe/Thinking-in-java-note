package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 4, page 352
/* Add a method to the class Sequence.SequenceSelector that produces the
* reference to the outer class Sequence.
*/
/**
 * Created by wangcheng on 2017/5/25.
 */
interface Selector4{
    boolean end();
    Object current();
    void next();
}
public class Sequence4 {
    private Object[] items;
    private int next = 0;
    public void test(){System.out.println("Sequence4.test()");}
    public Sequence4(int size){items = new Object[size];}
    public void add(Object x){
        if(next < items.length){
            items[next++] = x;
        }
    }
    private class SequenceSelector implements Selector4{
        private int i = 0;
        public boolean end(){return i == items.length;}
        public Object current(){return items[i];}
        public void next(){if(i<items.length) i++;}

        public Sequence4 sequence4(){return Sequence4.this;}
    }
    public Selector4 selector4(){
        return new SequenceSelector();
    }
    public static void main(String[] args){
        Sequence4 sequence = new Sequence4(10);
        for(int i = 0;i<10;i++){
            sequence.add(Integer.toString(i));
        }
        Selector4 selector = sequence.selector4();
        while (!selector.end()){
            System.out.println(selector.current() + " ");
            selector.next();
        }
        //cast and test
        ((SequenceSelector)selector).sequence4().test();
    }
}
