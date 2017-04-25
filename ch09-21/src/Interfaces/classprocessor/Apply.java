package Interfaces.classprocessor;

import java.util.*;
//本例中，创建一个能够根据所传递的参数对象的不同而具有不同行为的方法，被称为策略设计模式
/**
 * Created by wangcheng on 2017/4/23.
 */
class Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){return input;}
}
class Upcase extends Processor{
    String process(Object input){
        return ((String)input).toUpperCase();
    }
}
class Downcase extends Processor{
    String process(Object input){ //Covariant return
        return ((String)input).toLowerCase();
    }
}
class Splitter extends Processor{
    String process(Object input){
        //the split() argument divides a string into pieces;
        return Arrays.toString(((String)input).split(" "));
    }
}
public class Apply {
    public static void process(Processor p,Object s){
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static String s = "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args){
        process(new Upcase(),s);
        process(new Downcase(),s);
        process(new Splitter(),s);
    }
}
