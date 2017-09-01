package typeinfo;

/**
 * Created by wangcheng  on 2017/9/1.
 */
public class SweetShop7 {
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: sweetName");
        }
        Class c = null;
        try{
            c = Class.forName(args[0]);
        }catch (ClassNotFoundException e){
            System.out.println("Couldn't find + args[0]");
        }
    }
}
