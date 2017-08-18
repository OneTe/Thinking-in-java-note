package exceptions;
//Demonstrating the Exception Methods
/**
 * Created by wangcheng on 2017/8/18.
 */
public class ExceptionMethods {
    public static void main(String[] args){
        try {
            throw new Exception("My Exception");
        }catch(Exception e){
            System.out.println("Caught Exception");
            System.out.println("getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage()" + e.getLocalizedMessage());
            System.out.println("toString()" + e);
            System.out.print("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}
