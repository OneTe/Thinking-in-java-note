package holding;
/*
第一种情况，Arrays.asList()的输出被传递给了ArrayList()的构造器，这将创建一个ia的元素的ArrayList，因此打乱这些引用不会修改该数组，
但是如果直接使用Arrays.asList(ia)的结果，这种打乱就会修改ia的顺序。意识到Arrays.asList()产生的List对象会使用底层数组作为其物理
实现是很重要的。只要你执行的操作会修改这个List，并且你不想原来的数组被修改，就应该在另一个容器种创建一个副本。
 */
import java.util.*;
/**
 * Created by wangcheng on 2017/8/15.
 */
public class ModifyingArraysAsList {
    public static void main(String[] args){
        Random rand = new Random(47);
        Integer[] ia = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(ia));
        System.out.println("Before shuffling: " + list1);
        Collections.shuffle(list1,rand);
        System.out.println("After shuffling: " + list1);
        System.out.println("array: " + Arrays.toString(ia));

        List<Integer> list2 = Arrays.asList(ia);
        System.out.println("Before shuffing: " + list2);
        Collections.shuffle(list2,rand);
        System.out.println("After shuffling: " + list2);
        System.out.println("array: " + Arrays.toString(ia));
    }
}
