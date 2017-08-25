package exceptions;
//Guaranteeing proper cleanup of a resource
/**
 * Created by wangcheng on 2017/8/25.
 */
public class Cleanup {
    public static void main(String[] args){
        try {
            InputFile in = new InputFile("src/exceptions/Cleanup.java");
            try {//在创建需要清理的对象之后，立即进入一个try-catch语句块
                String s;
                int i = 1;
                while ((s = in.getLine()) !=null){
                   //System.out.println(s.toString()); ;//Perform line-by-line processing here
                }
            }catch (Exception e){
                System.out.println("Caught exception in main");
                e.printStackTrace(System.out);
            }finally {
                in.dispose();
            }
        }catch (Exception e){
            System.out.println("InputFile construction failed");
        }
    }
}
