package exceptions;

/**
 * Created by wangcheng on 2017/8/23.
 */
class ExceptionA1 extends Exception{
    ExceptionA1(String msg){super(msg);}
}
class ExceptionB1 extends Exception{
    ExceptionB1(String msg){super(msg);}
}
class ExceptionC1 extends Exception{
    ExceptionC1(String msg){super(msg);}
}
public class Ex13 {
    public static void f(int x) throws ExceptionA1,ExceptionB1,ExceptionC1{
        if(x < 0){
            throw new ExceptionA1("x < 0");
        }
        if(x == 0){
            //throw new ExceptionB1("x == 0");
            throw new NullPointerException();
        }
        if(x > 0){
            throw new ExceptionC1("x > 0");
        }
    }
    public static void main(String[] args){
        try{
            f(0);
            f(1);
            f(-1);
        }catch (Exception e){
            System.out.println("Caught Exception");
            e.printStackTrace(System.out);
        }finally {
            System.out.println("Always be here");
        }
        System.out.println("ada");
    }
}