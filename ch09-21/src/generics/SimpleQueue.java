package generics;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by wangcheng  on 2017/10/13.
 */
public class SimpleQueue<T> implements Iterable<T> {
    private LinkedList<T> storage = new LinkedList<T>();
    public void add(T t){storage.offer(t);}
    public T get(){return storage.poll();}

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
