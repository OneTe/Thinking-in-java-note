package holding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangcheng on 2017/7/28.
 */
class Tester{
    public static int counter = 0;
    private int id = counter++;
    public String toString(){return String.valueOf(id);};
}
public class Ex7{
    public static void main(String[] args){
        Tester[] t = new Tester[10];
        for(int i = 0;i < t.length;i++)
            t[i] = new Tester();
        List<Tester> lt = new ArrayList<Tester>();
        for(Tester x : t) lt.add(x);
        System.out.println("list of Tester: " + lt);
        List<Tester> sub = lt.subList(2,6);
        System.out.println("subList: " + sub);
        //produces run time ConcurrentModificationException:
        lt.removeAll(sub);
        //so,first make copy,remove sub ,re-assign lt:
        //好像现在不需要make copy了，可以直接删除了
//        List<Tester> copy = new ArrayList<Tester>(lt);
//        copy.removeAll(sub);
//        System.out.println("copy: " + copy);
//        lt = copy;
        System.out.println("list of Tester: " + lt);
    }
}

//自己写
//class Person{}
//public class Ex7 {
//    public static void main(String[] args) {
//        List<Person> a = new ArrayList<>();
//        for(int i = 0;i<5;i++)
//            a.add(new Person());
//        for(Person e:a)
//            System.out.println(e);
//        System.out.println();
//        List<Person> b = a.subList(1,3);
//        for(Person c:b)
//            System.out.println(c);
//        a.removeAll(b);
//        System.out.println();
//        for(Person d :a)
//            System.out.println(d);
//    }
//}
