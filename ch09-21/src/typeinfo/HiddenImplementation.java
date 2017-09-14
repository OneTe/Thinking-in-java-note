package typeinfo;

import typeinfo.packageaccess.HiddenC;
import typeinfo.interfacea.A1;
import java.lang.reflect.*;
/**
 * Created by wangcheng  on 2017/9/14.
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A1 a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getSimpleName());
        //compile error: can't find C1
        /*
        if(a instanceof C1){
            //xxxx
        }
        */
        //使用反射，可以达到调用所以方法的目的，甚至是private
        callHiddenMethod(a,"g");
        callHiddenMethod(a,"u");
        callHiddenMethod(a,"v");
        callHiddenMethod(a,"w");
    }
    static void callHiddenMethod(Object a, String methodName) throws Exception{
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }

}