package exceptions;
//Now an exception can be lost.
/**
 * Created by wangcheng on 2017/8/23.
 */

class VeryImportantException extends Exception{
    public String toString(){
        return "A very important exception";
    }
}
class HoHumException extends Exception{
    public String toString(){
        return "A trivial exception";
    }
}
public class LostMessage {
    void f() throws VeryImportantException{
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException{
        throw new HoHumException();
    }
    public static void main(String[] args){
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();//VeryImportantException这个异常丢失了
            }finally {
                lm.dispose();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
