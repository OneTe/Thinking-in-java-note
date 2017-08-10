package holding;
// TIJ4 Chapter Holding, Exercise 27, page 424
/* Write a class called Command that contains a String and has a method operation()
* that displays the String. Write a second class with a method that fills a Queue
* with Command objects and returns it. Pass the filled Queue to a method in a third
* class that consumes the objects in the Queue and calls their operation() methods.
*/
/**
 * Created by wangcheng on 2017/8/10.
 */
import java.util.*;
class Commanda{
    String s;
    Commanda(String s){this.s = s;}
    void operation(){System.out.println(s);}
}
class Build{
    Queue<Commanda> makeQ(){
        Queue<Commanda> q = new LinkedList<>();
        for(int i =0;i<10;i++){
            q.offer(new Commanda(i + " "));
        }
        return q;
    }
}
public class Queue27a {
    public static void commandEater(Queue<Commanda> qc){
        while (qc.peek()!=null){
            qc.poll().operation();
        }
    }
    public static void main(String[] args){
        Build b = new Build();
        commandEater(b.makeQ());
    }
}
