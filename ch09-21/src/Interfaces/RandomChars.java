package Interfaces;
import java.util.*;
import java.nio.*;
// TIJ4 Chapter Interfaces, Exercise 16, page 334
/* Create a class that produces a sequence of chars. Adapt this class so
* that it can be an input to a Scanner object.
*/
/**
 * Created by wangcheng on 2017/5/12.
 */
public class RandomChars {
    private static Random rand = new Random();
    public char next(){
        return (char)rand.nextInt(128);
    }
    public static void main(String[] args){
        RandomChars rc = new RandomChars();
        for(int i =0;i<10;i++){
            System.out.println(rc.next() + " ");
        }
    }
}
