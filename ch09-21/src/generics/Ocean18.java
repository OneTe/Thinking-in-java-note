package generics;
// TIJ4 Chapter Generics, Exercise 18, page 647
// Following the form of BankTeller.java, create an example where
// BigFish eat LittleFish in the ocean.
/**
 * Created by wangcheng  on 2017/9/20.
 */
import java.util.*;
import net.mindview.util.*;
class BigFish{
    private static long counter = 0;
    private final long id = ++counter;
    private BigFish(){}
    public String toString(){
        return "BigFish " + id;
    }
    public static Generator<BigFish> generator(){
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}
class LittleFish{
    private static long counter = 0;
    private final long id = ++counter;
    private LittleFish(){}

    @Override
    public String toString() {
        return "LittleFish " + id;
    }
    public static Generator<LittleFish> generator =
            new Generator<LittleFish>() {
                @Override
                public LittleFish next() {
                    return new LittleFish();
                }
            };
}
public class Ocean18 {
    public static void eat(BigFish bf,LittleFish lf){
        System.out.println(bf + " eats " + lf);
    }
    public static void main(String[] args){
        Random rand = new Random(47);
        List<BigFish> hunters = new ArrayList<>();
        Generators.fill(hunters,BigFish.generator(),3);
        Queue<LittleFish> school = new LinkedList<>();
        Generators.fill(school,LittleFish.generator,15);
        for(LittleFish f : school){
            eat(hunters.get(rand.nextInt(hunters.size())),f);
        }
    }
}
