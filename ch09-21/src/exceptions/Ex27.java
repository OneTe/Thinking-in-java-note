package exceptions;

/**
 * Created by wangcheng  on 2017/8/28.
 */
public class Ex27 {
    private static int[] ia = new int[2];
    public static void main(String[] args){
        try {
            ia[2] = 3;
        }catch (ArrayIndexOutOfBoundsException e){
           throw new RuntimeException(e);
        }
    }
}

