package generics;
//在泛型代码内部，无法获得任何有关泛型参数类型的信息
/**
 * Created by wangcheng  on 2017/9/20.
 */
import java.util.*;
class Frob{}
class Fnorkle{}
class Quark<Q>{}
class Particple<POSITION,MOMENTUM>{}
public class LostInformation {
    public static void main(String[] args){
        List<Frob> list = new ArrayList<>();
        Map<Frob,Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particple<Long,Double> p = new Particple<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}
