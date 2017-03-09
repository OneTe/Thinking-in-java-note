/**
 * Created by wangcheng on 2017/3/5.
 */
public class VarargEx19 {
    static void f(String... args){
        for(String s : args){
            System.out.print(s + " ");
        }
        System.out.println();
    }
    static void f1(String[] args){
        for(String s :args){
            System.out.print(s + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        f(new String[]{"one", "two", "three"});
        f("four","five");
       // f1("one","two"); 看出数组类型参数无法兼容可变类型参数
        f1(new String[]{"one","two"});
    }
}
