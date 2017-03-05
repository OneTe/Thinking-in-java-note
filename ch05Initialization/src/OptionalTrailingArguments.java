import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.DoubleSummaryStatistics;
import java.util.Objects;

/**
 * Created by wangcheng on 2017/3/3.
 * 可变参数类型必须作为参数列表的最后一项，而不能放在定长参数的前面
 */
class A{}
public class OptionalTrailingArguments{
    static void f(int required,String... trailing){
        System.out.print("required: "+ required + " ");
        for(String s : trailing){
            System.out.print(s + " ");
        }
        System.out.println();
    }
    static void f1(Object[] args){
        for(Object obj: args){
            System.out.print(obj + " ");
        }
    }
    static void f2(Object... args){
        for(Object obj : args){
            System.out.print(obj + " ");
        }
    }
    public static void main(String[] args){
        f(1, "one");
        f(1,"two","three");
        f(0);
        f1(new Object[]{"one","two","three"});
        System.out.println();
        f2(new A(),new A());
        f2("one","two","three");
        f2();  //  Empty is ok
    }
}
