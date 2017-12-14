package net.mindview.util;

//T extends Enum<T> 表示T是enum的一个实例
import java.util.*;
/**
 * Created by wangcheng  on 2017/12/14.
 */
public class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }
}
