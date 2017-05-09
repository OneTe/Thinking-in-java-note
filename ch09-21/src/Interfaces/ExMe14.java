package Interfaces;

/**
 * Created by wangcheng on 2017/5/9.
 */
interface Phone{
    void call();
    void message();
}
interface XiaoMi{
    void wecat();
    void qq();
}
interface Huawei{
    void takePhoto();
    void game();
}
interface Oppo extends Phone,XiaoMi,Huawei{
    void meiYan();
}
class Say{
    void saysomething(){
        System.out.println("say Hello!");
    }
}
class SuperPhone extends Say implements Oppo{
    public void call(){System.out.println("call()");}
    public void message(){}
    public void wecat(){}
    public void qq(){}
    public void takePhoto(){}
    public void game(){}
    public void meiYan(){}
}
public class ExMe14 {
    static void q(Phone p){p.call();}
    static void w(XiaoMi x){x.wecat();}
    static void e(Huawei h){h.takePhoto();}
    static void r(Oppo o){o.meiYan();}
    public static void main(String[] args){
        SuperPhone S = new SuperPhone();
        q(S);
        w(S);
        e(S);
        r(S);
    }
}
