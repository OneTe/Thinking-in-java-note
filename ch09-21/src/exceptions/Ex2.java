package exceptions;

/**
 * Created by wangcheng on 2017/8/17.
 */
class Exception2 extends Exception{
    public Exception2(String msg){super(msg);}
}
public class Ex2 {
    private static Integer i = null;
    public static void f(Integer i) throws Exception2{
        if(i == null){
            throw new Exception2("the object is not init");
        }
    }
    public static void main(String[] args){
        try{
            f(i);
        }catch (Exception2 e){
            e.printStackTrace();
        }
    }
}
