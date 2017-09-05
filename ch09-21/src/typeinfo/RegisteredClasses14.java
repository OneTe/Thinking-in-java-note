package typeinfo;

/**
 * Created by wangcheng  on 2017/9/5.
 */
import java.util.*;
class Part1{
    public String toString(){
        return getClass().getSimpleName();
    }
    static List<Class<? extends Part1>> partClass = new ArrayList<>();
    static{
        partClass.add(new AirFilter1().getClass());
        partClass.add(new CabinAirFilter1().getClass());
        partClass.add(new OilFilter1().getClass());
        partClass.add(new FanBelt1().getClass());
        partClass.add(new GeneratorBelt1().getClass());
        partClass.add(new PowerSteeringBelt1().getClass());
    }
    private static Random rand = new Random(47);
    public static Part1 createRandom(){
        int n = rand.nextInt(partClass.size());
        try {
            return partClass.get(n).newInstance();
        }catch (InstantiationException e){
            throw new RuntimeException(e);
        }catch (IllegalAccessException e){
            throw new RuntimeException(e);
        }

    }
}
class Filter1 extends Part1{}
class AirFilter1 extends Filter1{
}
class CabinAirFilter1 extends Filter1{
}
class OilFilter1 extends Filter1{
}

class Belt1 extends Part1{}

class FanBelt1 extends Belt1{
}
class GeneratorBelt1 extends Belt1{
}
class PowerSteeringBelt1 extends Belt1{
}
public class RegisteredClasses14 {
    public static void main(String[] args){
        for(int i = 0;i<10;i++){
            System.out.print(Part1.createRandom() + " ");
        }
    }
}
