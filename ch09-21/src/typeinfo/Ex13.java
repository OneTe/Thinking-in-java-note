package typeinfo;

import net.mindview.util.TypeCounter;

/**
 * Created by wangcheng  on 2017/9/5.
 */
import java.util.*;
public class Ex13 {
    public static void main(String[] args){
        TypeCounter counter = new TypeCounter(Part.class);
        List<Part> partList = new ArrayList<>();
        for(int i =0;i<20;i++){
            partList.add(Part.createRandom());
        }
        for(Part part : partList){
            System.out.print(part.getClass().getSimpleName() + " ");
            counter.count(part);
        }
        System.out.println();
        System.out.println(counter);
    }
}
