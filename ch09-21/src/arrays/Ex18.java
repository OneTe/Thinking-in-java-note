package arrays;


import java.util.Arrays;

/**
 * Created by wangcheng  on 2017/10/17.
 */
public class Ex18 {
    public static void main(String[] args){
        BerylliumSphere[] bl1 = new BerylliumSphere[3];
        for(int i = 0;i<bl1.length;i++){
            bl1[i] = new BerylliumSphere();
        }
        //can't use this ,otherwise the result is :[Sphere 0, Sphere 0, Sphere 0]
       // Arrays.fill(bl1,new BerylliumSphere());
        System.out.println(Arrays.toString(bl1));
        BerylliumSphere[] bl2 = new BerylliumSphere[4];
        System.out.println(Arrays.toString(bl2));
        System.arraycopy(bl1,0,bl2,0,bl1.length);
        System.out.println(Arrays.toString(bl2));
    }
}
