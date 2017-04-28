package Interfaces.interfaceprocessor;

/**
 * Created by wangcheng on 2017/4/26.
 */
public class Apply {
    public static void process(Processor p,Object s){
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
