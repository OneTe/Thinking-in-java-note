package exceptions;

/**
 * Created by wangcheng on 2017/8/25.
 */
class TeException extends Exception{}
class Base{
    Base(){
        throw new RuntimeException("hah");
    }

}
public class Ex21 extends Base{
    public Ex21() throws TeException{
        try{
            //!super(); this is not allowed
            throw new TeException();
        }catch (TeException e){
            System.out.println("in the Ex21");
        }
    }
    public static void main(String[] args){
        try {
            Ex21 e = new Ex21();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
