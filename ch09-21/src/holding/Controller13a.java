package holding;
// TIJ4 Chapter Holding, Exercise 13, page 412
/* In the innerclasses/GreenhouseController.java example, the class
* Controller uses an ArrayList. Change the code to use a LinkedList
* instead, and use an Iterator to cycle through the set of events.
*/

import innerclasses.controller.Event;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by wangcheng on 2017/8/3.
 */
public class Controller13a {
    private LinkedList<Event> evenList = new LinkedList<>();
    public void addEvent(Event c){ evenList.add(c);}
    public void run(){
        LinkedList<Event> eventListCopy = new LinkedList<>(evenList);
        ListIterator<Event> it = eventListCopy.listIterator();
        while (it.hasNext()){
            it.next().action();
            it.previous();
            System.out.println(it.next());
        }
    }
}
