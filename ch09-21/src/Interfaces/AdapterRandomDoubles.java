package Interfaces;

import java.util.*;
import java.nio.*;
/**
 * Created by wangcheng on 2017/5/12.
 */
public class AdapterRandomDoubles extends RandomDoubles
implements Readable {
    private int count;
    public AdapterRandomDoubles(int count){
        this.count = count;
    }
    public int read(CharBuffer cb){
        if(count --== 0){
            return -1;
        }
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }
    public static void main(String[] args){
        Scanner s = new Scanner(new AdapterRandomDoubles(7));
        while(s.hasNextDouble()){
            System.out.println(s.nextDouble() + " ");
        }
    }
}
