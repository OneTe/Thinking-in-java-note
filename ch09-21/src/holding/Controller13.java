package holding;

/**
 * Created by wangcheng on 2017/8/3.
 */
import innerclasses.controller.Event;
import sun.awt.image.ImageWatched;

import java.util.*;

public class Controller13 {
    private LinkedList<Event> events = new LinkedList<>();
    public void add(Event c){
        events.add(c);
    }
    public void run(){
        LinkedList<Event> eventCopy = new LinkedList<>(events);
        ListIterator<Event> lt = eventCopy.listIterator();
        if(lt.hasNext()){
            Event i = lt.next();
            if(i.ready()){
                System.out.println(i);
                i.action();
                lt.remove();
            }
        }
    }
}
