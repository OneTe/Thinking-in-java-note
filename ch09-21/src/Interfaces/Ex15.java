package Interfaces;

import java.util.Arrays;
//冒泡排序
/**
 * Created by wangcheng on 2017/5/9.
 */
public class Ex15 {
    public static void main(String[] args) {
        int[] intArray = {10, 2, 5, 23,4};
        for (int i = 0; i < intArray.length-1; i++) {
            for(int j = 0;j<intArray.length-1-i;j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(intArray));
    }
}
