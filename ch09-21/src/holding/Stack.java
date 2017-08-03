package holding;
//用LinkedList实现栈的所有功能

import java.util.LinkedList;

/**
 * Created by wangcheng on 2017/8/3.
 */
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<T>();
    public void push(T v){storage.addFirst(v);}
    public T peek(){return storage.getFirst();}
    public T pop(){return storage.removeFirst();}
    public boolean empty(){return storage.isEmpty();}
    public String toString(){return storage.toString();}
}
