package innerclasses.controller;
//The reusable framework for control systems.

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangcheng on 2017/7/3.
 */
public class Controller {
    //A class from java.util to hold Event objects:
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event c){eventList.add(c);}
    public void run(){
        while (eventList.size()>0){
            //make a copy so you're not modifying the list
            //while you're selecting the elements in it;

            for(Event e:new ArrayList<Event>(eventList)){
                if(e.ready()){
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
