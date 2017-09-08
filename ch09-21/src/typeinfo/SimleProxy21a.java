package typeinfo;

/**
 * Created by wangcheng  on 2017/9/8.
 */
import java.util.*;
class SimpleProxy21a implements Interface {
    private Interface proxied;
    private static int doCount = 0;
    private static int sECount = 0;
    public SimpleProxy21a(Interface proxied) {
        this.proxied = proxied;
    }
    public void doSomething() {
        long timeIn = new Date().getTime();
        System.out.println("Time called doSomething() " + doCount + ": " + timeIn + " msecs");
        System.out.println("on " + new Date());
        doCount++;
        proxied.doSomething();
        System.out.println("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
    }
    public void somethingElse(String arg) {
        long timeIn = new Date().getTime();
        System.out.println("Time called somethingElse() " + sECount + ": " + timeIn + " msecs");
        System.out.println("on " + new Date());
        sECount++;
        proxied.somethingElse(arg);
        System.out.println("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
    }
}

class SimpleProxyDemo21a {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println();
        consumer(new SimpleProxy21a(new RealObject()));
        System.out.println();
        consumer(new SimpleProxy21a(new RealObject()));
        System.out.println();
        consumer(new SimpleProxy21a(new RealObject()));
    }
}
