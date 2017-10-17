package arrays;
//创建多维数组

import java.util.Arrays;

/**
 * Created by wangcheng  on 2017/10/16.
 */
public class MultidimensionalPrimitiveArray {
    public static void main(String[] args){
        int[][] a = {
                {1,2,3,4},
                {5,6,7,8},
        };
        System.out.println(Arrays.deepToString(a));
    }
}
