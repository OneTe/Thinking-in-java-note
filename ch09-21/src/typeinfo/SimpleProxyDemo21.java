package typeinfo;

/**
 * Created by wangcheng  on 2017/9/8.
 */
class SimpleProxy21 implements Interface{
    private Interface proxied;
    private static int count1 = 0;
    public SimpleProxy21(Interface proxied){
        this.proxied = proxied;
    }
    public void doSomething(){
        System.out.println("SimpleProxy doSomething");
        System.out.println("count1:" + (++count1));
        proxied.doSomething();
    }
    public void somethingElse(String arg){
        System.out.println("SimpleProxy somethingElse");
        proxied.somethingElse(arg);
    }
}
public class SimpleProxyDemo21 {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args){
        //consumer(new RealObject());
        for(int i =0;i<5;i++)consumer(new SimpleProxy21(new RealObject()));
    }
}
