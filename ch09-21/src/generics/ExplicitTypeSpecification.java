package generics;
//显式类型说明
/**
 * Created by wangcheng  on 2017/9/19.
 */
import typeinfo.pets.*;
import java.util.*;
import net.mindview.util.*;

public class ExplicitTypeSpecification {
    static void f(Map<Person,List<Pet>> petPerson){}
    public static void main(String[] args){
        f(New.<Person,List<Pet>>map());
    }
}
