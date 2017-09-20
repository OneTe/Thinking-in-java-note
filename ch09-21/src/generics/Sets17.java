package generics;
// TIJ4 Chapter Generics, Exercise 17, page 645
/* Study the JDK documentation for EnumSet. You'll see that there's a
* clone() method defined. However, you cannot clone() from the reference
* to the Set interface passed in Sets.java. Can you modify Sets.java to
* handle both the general case of a Set interface as shown, and the
* special case of an EnumSet, using clone() instead of creating a new
* HashSet?
*/
/**
 * Created by wangcheng  on 2017/9/20.
 */
import java.util.*;
import generics.watercolors.*;
public class Sets17<T> {
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        try {
            if(a instanceof EnumSet){
            Set<T> result = ((EnumSet)a).clone();
            result.addAll(a);
            return result;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    public static <T>
    Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
    //Subtract subset from superset:
    public static <T> Set<T> difference(Set<T> superset,Set<T> subset){
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }
    //Reflexive--everything not in the intersection:
    public static <T> Set<T> complement(Set<T> a,Set<T> b){
        return difference(union(a,b),intersection(a,b));
    }
    public static void main(String[] args){
        Set<Watercolors> set1 =
                EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.VIRIDIAN_HUE);
        Set<Watercolors> set2 =
                EnumSet.range(Watercolors.CERULEAN_BLUE_HUE, Watercolors.BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + union(set1, set2));
    }
}
