package holding;
//Upcasting to a Queue from  a linkedList
/*
offer()方法将一个元素插入到队尾，或者返回false
 */
/**
 * Created by wangcheng on 2017/8/9.
 */
import java.util.*;

public class QueueDemo {
    public static void PrintQ(Queue queue){
        while (queue.peek() != null){
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        Random rand = new Random(47);
        for(int i = 0;i<10;i++){
            queue.offer(rand.nextInt(i+10));
        }
        PrintQ(queue);
        Queue<Character> qc = new LinkedList<>();
        for(char c : "Brontosaurus".toCharArray()){
            qc.offer(c);
        }
        PrintQ(qc);
    }
}
