package generics;

/**
 * Created by wangcheng  on 2017/9/19.
 */
import net.mindview.util.*;
public class BasicGeneratorDemo {
    public static void main(String[] args){
        Generator<CountedObject> gen =  
            BasicGenerator.create(CountedObject.class);
        for(int i = 0;i<5;i++){
            System.out.println(gen.next());
        }
        //Ex14,使用显式的构造器
        Generator<CountedObject> gen1 = new BasicGenerator(CountedObject.class);
        for(int i = 0;i<5;i++){
            System.out.println(gen1.next());
        }
    }
}
