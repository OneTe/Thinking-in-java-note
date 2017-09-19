package generics;

/**
 * Created by wangcheng  on 2017/9/19.
 */
import typeinfo.Person;
import typeinfo.pets.*;
import java.util.*;
import net.mindview.util.*;
public class LimitsOfInference {
    static void
    f(Map<Person,List<? extends Pet>> petPerson){}
    public static void main(String[] args){
        f(New.map());//Does not compile
    }
}
