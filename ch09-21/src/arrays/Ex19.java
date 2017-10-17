package arrays;

import java.util.Arrays;

/**
 * Created by wangcheng  on 2017/10/17.
 */
public class Ex19 {
    protected int x;
    Ex19(int x){
        this.x =x;
    }
    public  boolean equal(Object b){
        return (b.getClass().getSimpleName() == "Ex19"
                && this.x == ((Ex19)b).x) ? true : false;
    }
    public static void main(String[] args){
        Ex19[] x1 = {new Ex19(1),new Ex19(2)};
        Ex19[] x2 = {new Ex19(1),new Ex19(2)};
        System.out.println(Arrays.equals(x1,x2));
        System.out.println(x1.equals(x2));
    }
}
