package exceptions;

/**
 * Created by wangcheng on 2017/8/17.
 */
public class Ex3 {
    public static void main(String[] args){
        int box[] =new int[5];
        try {
            for(int i = 0 ;i<6;i++){
                box[i] = i;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }finally {
            System.out.println("go there!");
        }
    }
}
