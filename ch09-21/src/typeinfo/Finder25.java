package typeinfo;

/**
 * Created by wangcheng  on 2017/9/14.
 */
import typeinfo.secret.*;
import java.lang.reflect.*;
public class Finder25 {
    public static void main(String[] args) throws Exception{
        A2 a = SecretMaker.makeSecret();
        System.out.println("a is of class type: " + a.getClass().getName());
        for(Method m : a.getClass().getDeclaredMethods()){
            m.setAccessible(true);
            m.invoke(a);
        }
    }
}
