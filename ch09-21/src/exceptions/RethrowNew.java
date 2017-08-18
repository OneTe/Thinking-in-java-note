package exceptions;
//有可能在捕获异常之后抛出另一个异常。这么的话，得到的效果就类似使用fillInStackTrace(),有关原来异常发生点的信息会丢失
/**
 * Created by wangcheng on 2017/8/18.
 */
class OneException extends Exception{
    public OneException(String s){
        super(s);
    }
}
class TwoException extends Exception{
    public TwoException(String s){
        super(s);
    }
}
public class RethrowNew {
    public static void f() throws OneException{
        System.out.println("Originating the exception in f()");
        throw new OneException("thrown from f()");
    }
    public static void main(String[] args){
        try{
            try {
            f();
        }catch(OneException e){
            System.out.println("Caught in inner try,e.printStackTrace()");
            e.printStackTrace(System.out);
            throw new TwoException("from inner try");
            }
        }catch (TwoException e){
            System.out.println("Caught in outer try,e.printStackTrace()");
            e.printStackTrace(System.out);
        }//最后那个异常仅知道自己来自main(),而对f()一无所知
//          try {
//            f();
//        }catch(OneException e){
//            System.out.println("Caught in inner try,e.printStackTrace()");
//            e.printStackTrace(System.out);
//            }
    }
}
