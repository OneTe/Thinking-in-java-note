package typeinfo;
//动态代理
/**
 * Created by wangcheng  on 2017/9/6.
 */

import java.lang.reflect.*;
class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if(args != null){
            for(Object arg: args){
                System.out.println(" " + arg);
            }
        }
        return method.invoke(proxied,args);
    }
}
public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args){
        RealObject real = new RealObject();
        consumer(real);
        //Insert a proxy and call again:
        //Proxy.newProxyInstance()可以创建动态代理，这个方法需要三个参数：
        //1:一个类加载器 2:一个你希望该代理实现的接口列表（不能是类或抽象类）3:InvocationHandler接口的一个实现
        Interface proxy = (Interface)Proxy.newProxyInstance(
          Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }
}
