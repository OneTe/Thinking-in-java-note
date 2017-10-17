package arrays;

import java.util.Arrays;

/**
 * Created by wangcheng  on 2017/10/16.
 */
public class Ex2 {
    public static BerylliumSphere[] fillWithBer(int size){
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[size];
        if(size > 0){
            for(int i = 0;i<size;i++){
                berylliumSpheres[i] = new BerylliumSphere();
            }
        }
        return berylliumSpheres;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(fillWithBer(3)));
    }
}
