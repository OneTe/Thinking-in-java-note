/**
 * Created by wangcheng on 2017/3/10.
 * 每一个非基本类型都有一个toString方法，当编译器需要一个String而你只有一个对象时，该方法便会会调用。
 * 它通常只是为了方便输出，比如System.out.println(xx)，
 * 括号里面的“xx”如果不是String类型的话，就自动调用xx的toString()方法
 */
class WaterSource{
    private String s;
    WaterSource(){
        System.out.println("WaterSource()");
        s = "Constructed";
    }
    public String toString(){
        return s;
    }
}
public class SprinklerSystem {
    private String Value1,Value2,Value3,Value4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;
    public String toString(){
        return
                "Value1 = " + Value1 + " " +
                "Value2 = " + Value2 + " " +
                "Value3 = " + Value3 + " " +
                "Value4 = " + Value4 + "\n" +
                "i = " + i + " " + f + " " +
                "source = " + source;
    }
    public static void main(String[] args){
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);
    }
}
