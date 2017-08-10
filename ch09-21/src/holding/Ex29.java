package holding;
// TIJ4 Chapter Holding, Exercise 29, page 427
/* Fill a PriorityQueue (using offer()) with Double values created using
* java.util.Random, then remove the elements using poll() and display them.
*/
import java.util.PriorityQueue;

/**
 * Created by wangcheng on 2017/8/10.
 */
class TestObject extends Object{}
public class Ex29 {
    public static void main(String[] args){
        TestObject t1 = new TestObject();
        TestObject t2 = new TestObject();
        PriorityQueue<TestObject> testObjects = new PriorityQueue<>();
        testObjects.offer(t1);
        testObjects.offer(t2);
    }
}
