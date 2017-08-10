package holding;

/**
 * Created by wangcheng on 2017/8/10.
 */
import java.util.*;
class Command{
    private String s;
    Command(String s){
        this.s = s;
    }
    public void operation(){
        System.out.println(s);
    }
}
class Second{
    public Queue addCommand(Command c){
        Queue<Command> queue = new LinkedList<>();
        queue.offer(c);
        return queue;
    }
}
public class Queue27 {
    public void wast(Queue<Command> queue){
        while (queue.peek()!=null){
           Command c =  queue.remove();
           c.operation();
        }
    }
    public static void main(String[] args){
        Queue27 q = new Queue27();
        q.wast(new Second().addCommand(new Command("hha")));
    }
}
