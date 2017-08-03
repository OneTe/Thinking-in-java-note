package holding;
//Set不保存重复的元素，Set具有与Collection完全一样的接口，只是行为不用（这是继承与多态思想的典型应用）
//查找是Set中最重要的操作，通常会选择一个HashSet的实现，它专门对快速查找进行了优化
import java.util.*;

/**
 * Created by wangcheng on 2017/8/3.
 */
public class SetOfInteger {
    public static void main(String[] args){
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<>();
        //在0到29之间的10000个随机数被添加到了Set中，每一个数都重复了很多次，但是每一个数只有一个实例出现在结果中
        for(int i = 0 ; i < 10000;i++){
            intset.add(rand.nextInt(50));
        }
        System.out.println(intset);
    }
}
//HashSet使用了散列，HashSet存储在内部时他是根据hashcode，只是Integer的hashCode刚刚好用的是Integer的value，结果看起来就过排序了