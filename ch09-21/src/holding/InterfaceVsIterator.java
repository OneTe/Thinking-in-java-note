package holding;

import java.util.*;
import typeinfo.pets.*;
/**
 * Created by wangcheng on 2017/8/11.
 */

public class InterfaceVsIterator {
    public static void display(Iterator<Pet> it){
        while (it.hasNext()){
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }
    public static void display(Collection<Pet> pets){
        //使用foreach语法，也可以是实现了Iterable的类，其实还是调用了iterator方法
        for(Pet p : pets){
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Pets p = new Pets();
        List<Pet> petList = p.arrayList(8);
        Set<Pet> petSet = new HashSet<>(petList);
        Map<String,Pet> petMap = new LinkedHashMap<>();
        String[] names  = ("Ralph, Eric, Robin, Lacey, " + "Britney, Sam, Spot, Fluffy").split(", ");
        for(int i = 0;i<names.length;i++){
            petMap.put(names[i],petList.get(i));
        }
        display(petList);
        display(petSet);
//        display(petList.iterator());
//        display(petSet.iterator());
//        System.out.println(petMap);
//        System.out.println(petMap.keySet());
//        display(petMap.values());
//        display(petMap.values().iterator());
    }
}
