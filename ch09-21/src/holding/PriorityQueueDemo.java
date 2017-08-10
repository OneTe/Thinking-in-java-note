package holding;

/**
 * Created by wangcheng on 2017/8/10.
 */
import java.util.*;
public class PriorityQueueDemo {
    public static void main(String[] args){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(47);
        for(int i = 0;i<10;i++){
            priorityQueue.offer(rand.nextInt(i+10));
        }
        QueueDemo.PrintQ(priorityQueue);
        List<Integer> ints = Arrays.asList(25,22,20,18,14,9,3,1,1,2,3,9,14,18,21,23,25);
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.PrintQ(priorityQueue);
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<>(strings);
        QueueDemo.PrintQ(stringPQ);
        stringPQ = new PriorityQueue<>(strings.size(),Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.PrintQ(stringPQ);

        Set<Character> charSet = new HashSet<>();
        for(char c :fact.toCharArray()){
            charSet.add(c);
        }
        PriorityQueue<Character> characterPQ = new PriorityQueue<>(charSet);
        QueueDemo.PrintQ(characterPQ);
    }
}
