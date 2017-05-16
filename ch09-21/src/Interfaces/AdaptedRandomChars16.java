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
public class AdaptedRandomChars16 extends RandomChars
implements Readable{
    private int count;
    public AdaptedRandomChars16(int count){
        this.count = count;
    }
    public int read(CharBuffer cb){
        if(count -- ==0){
            return -1;
        }
        String result = Character.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }
    public static void main(String[] args){
        Scanner s = new Scanner(new AdaptedRandomChars16(10));
        while (s.hasNext()){
            System.out.println(s.next() + " ");
        }
    }

}
