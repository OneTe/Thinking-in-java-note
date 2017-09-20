package generics;
//Combining generic types to make complex generic types.
/**
 * Created by wangcheng  on 2017/9/20.
 */
import java.util.*;
import net.mindview.util.*;

public class TupleList<A,B,C,D> extends ArrayList<FourTuple>{
    public static void main(String[] args){
        TupleList<Vehicle,Amphibian,String,Integer> tl =
                new TupleList<>();
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        for(FourTuple<Vehicle,Amphibian,String,Integer> i:tl){
            System.out.println(i);
        }
    }
}
