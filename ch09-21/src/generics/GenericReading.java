package generics;

/**
 * Created by wangcheng  on 2017/9/26.
 */
import java.util.*;
public class GenericReading {
    static <T> T readExact(List<T> list){
        return list.get(0);
    }
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());
    //A static method adapts to each call;
    static void f1(){
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);
        f = readExact(apples);
    }
    static class Reader<T>{
        T readExact(List<T> list){return list.get(0);}
    }
    static void f2(){
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruits);
        //Fruit a = fruitReader.readExact(apples); //Error
        //readExact(List<Fruit>);//can't be applied to (List<Apple>)
    }
    static class CovariantReader<T>{
        T readCovariant(List<? extends T> list){
            return list.get(0);
        }
    }
    static void f3(){
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        Fruit f = fruitReader.readCovariant(fruits);
        Fruit a = fruitReader.readCovariant(apples);
    }
    public static void main(String[] args){
        f1();f2();f3();
    }
}
