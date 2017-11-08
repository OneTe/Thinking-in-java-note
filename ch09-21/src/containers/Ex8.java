package containers;
// containers/Ex8.java
// TIJ4 Chapter Containers, Exercise 8, page 821
/* Create a generic, singly linked list class called SList, which, to keep
* things simple, does not implement the List interface. Each Link object in
* the list should contain a reference to the next element in the list, but
* not the previous one (LinkedList, in contrast, is a doubly linked list,
* which means it maintains links in both directions). Create your own
* SListIterator which, again for simplicity, does not implement ListIterator.
* The only method in SList other than toString() should be iterator(), which
* produces an SListIterator. The only way to insert and remove elements from
* an SList is through SListIterator. Write code to demonstrate SList.
*/
/**
 * Created by wangcheng  on 2017/11/8.
 */

import java.util.*;

class SList<E>{
    private Link<E> headLink = new Link<E>(null);
    SListIterator<E> iterator(){return new SListIterator<>(headLink);}
    public String toString(){
        if(headLink.next == null) return "SList: []";
        System.out.print("SList: [");
        SListIterator<E> it = this.iterator();
        StringBuilder s = new StringBuilder();
        while (it.hasNext()){
            s.append(it.next() + (it.hasNext() ? ", " : ""));
        }
        return s + "]";
    }
}
class SListIterator<E>{
    Link<E> current;
    SListIterator(Link<E> link){
        current = link;
    }
    public boolean hasNext(){
        return current.next != null;
    }
    public Link<E> next(){
        current = current.next;
        return current;
    }
    public void insert(E e){
        current.next = new Link<E>(e,current.next);
        current = current.next;
    }
    public void remove(){
        if(current.next != null){
            current.next = current.next.next;
        }
    }
}
class Link<E>{
    E e;
    Link<E> next;
    Link(E e,Link<E> next){
        this.e = e;
        this.next = next;
    }
    Link(E e){
        this(e,null);
    }
    public String toString(){
        if(e == null) return "null";
        return e.toString();
    }
}
public class Ex8 {
    public static void main(String[] args){
        SList<String> sl = new SList<String>();
        System.out.println(sl);
        SListIterator<String> slIter = sl.iterator();
        slIter.insert("hi");
        System.out.println(sl);
        slIter.insert("there");
        System.out.println(sl);
        slIter.insert("sweetie");
        System.out.println(sl);
        slIter.insert("pie");
        System.out.println(sl);

        SListIterator<String> slIter2 = sl.iterator();
        slIter2.remove();
        System.out.println(sl);
        slIter2.insert("hello");
        System.out.println(sl);
        slIter2.remove();
        System.out.println(sl);

        slIter2.remove();
        System.out.println(sl);
        slIter2.remove();
        System.out.println(sl);

        SListIterator<String> slIter3 = sl.iterator();
        slIter3.remove();
        System.out.println(sl);
    }
}
