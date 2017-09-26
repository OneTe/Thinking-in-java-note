package generics;

/**
 * Created by wangcheng  on 2017/9/26.
 */
import java.util.*;
public class GenericsAndCovariance {
    public static void main(String[] args){
        //Wildcards allow covariance:
        List<? extends Fruit> fruits = new ArrayList<Apple>();
        //Compile error: can't add any type of object:
        //fruits.add(new Apple());
        //fruits.add(new Fruit());
        //fruits.add(new Object());
        fruits.add(null);//Legal but uninteresting

        Fruit f = fruits.get(0);
    }
}
