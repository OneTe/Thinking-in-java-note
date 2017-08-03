package holding;
//LinkedList也像ArrayList一样实现了List接口，但它在执行某些操作（在List中间插入和移除）时比ArrayList更高效
//但在随机访问方面要差一些

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by wangcheng on 2017/8/3.
 */
public class LinkedListFeatures {
    public static void main(String[] args){
        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("ll: " + ll);
        //Identical:
        System.out.println("ll.getFirst(): " + ll.getFirst());
        System.out.println("ll.element(): " + ll.element());
        //Only differs im empty-list behavior:
        System.out.println("ll.peek(): " + ll.peek());
        //Identical: remove and return the first element:
        System.out.println("ll.remove(): " + ll.remove());
        System.out.println("ll.removeFirst(): " + ll.removeFirst());
        //Only differs im empty-list behavior:
        System.out.println("ll.poll(): " + ll.poll());
        System.out.println("ll: " + ll);
        ll.addFirst(6);
        System.out.println("After addFirst(): " + ll);
        ll.offer(7); //加到后面
        System.out.println("After off(): " + ll);
        ll.add(8);
        System.out.println("After add(): " + ll);
        ll.addLast(9);
        System.out.println("After addLast(): " + ll);
        System.out.println("ll.removeLast(): " + ll.removeLast());//移除并返回列表的最后一个元素
    }
}
