package holding;

/**
 * Created by wangcheng on 2017/8/10.
 */
import java.util.*;

public class Ex28 {
    public static void main(String[] args){
        Random rand = new Random(47);
        PriorityQueue<Double> priorityQueue =new PriorityQueue<>();
        for(int i = 0;i<10;i++){
            priorityQueue.offer(rand.nextDouble()*i);
        }
        QueueDemo.PrintQ(priorityQueue);
        while (priorityQueue.peek() != null){
            System.out.println(priorityQueue.poll() + " ");
        }
    }
}
