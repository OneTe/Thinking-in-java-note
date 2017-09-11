package typeinfo;
// TIJ4 Chapter Typeinfo, Exercise 22, page 598
// Modify SimpleDynamicProxy.java so that it measures method-call times.
/**
 * Created by wangcheng  on 2017/9/11.
 */
import java.util.*;
import java.lang.reflect.*;
class DynamicProxyHandler22 implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler22(Object proxied){
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long timeIn = new Date().getTime();
        System.out.println("**** proxy: " + proxy.getClass() +
        ", method: " + method + ",arg: " + args +
        ",invoked at " + timeIn + " on " + (new Date()));
        if(args != null){
            for(Object arg : args){
                System.out.println(" " + args);
            }
        }
        long timeOut = new Date().getTime();
        System.out.println("Method call-return time: " + (timeOut-timeIn) + " msecs");
        return method.invoke(proxied,args);
    }
}
public class SimpleDynamicProxy22 {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args){
        RealObject real = new RealObject();
        consumer(real);
        Interface proxy  = (Interface)Proxy.newProxyInstance(
          Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler22(real)
        );
        consumer(proxy);
    }
}
