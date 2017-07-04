package innerclasses.controller;
//the common methods for any control event

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by wangcheng on 2017/7/3.
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime){
        this.delayTime = delayTime;
        start();
    }
    public void start(){
        eventTime = System.nanoTime() + delayTime;
    }
    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();
}
