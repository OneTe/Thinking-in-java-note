/**
 * Created by wangcheng on 2017/3/5.
 */
public class VarargEx20 {
    public static void main(String... args){
        for(String s : args)
            System.out.print(s + " ");
        System.out.println();
    }
}
