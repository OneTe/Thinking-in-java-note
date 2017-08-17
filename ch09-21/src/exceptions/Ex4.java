package exceptions;

/**
 * Created by wangcheng on 2017/8/17.
 */
class MyException4 extends Exception{
    private String s;
    public MyException4(String msg){
        super(msg);
        s = msg;
    }
    public String show(){
        return s;
    }
}
public class Ex4 {
    public static void f() throws MyException4{
        throw new MyException4("hello");
    }
    public static void main(String[] args){
        try {
            f();
        }catch (MyException4 e){
            System.out.println(e.show());
            e.printStackTrace();
        }
    }
}
