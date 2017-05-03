package Interfaces;
//这个例子展示了使用接口的核心原因：为了能够向上转型为多个基类型，第二个原因与使用抽象基类相同：防止客户端程序员创建该类
//的对象，并确保这仅仅是建立一个接口
/**
 * Created by wangcheng on 2017/5/3.
 */
interface CanFight{
    void fight();
}
interface CanSwim{
    void swim();
}
interface CanFly{
    void fly();
}
interface CanClimb{
    void climb();
}
class ActionCharacter{
    public void fight(){}
}
class Hero extends ActionCharacter
    implements CanFight,CanSwim,CanFly,CanClimb{
    //Hero中没有提供fight的定义，但是它继承了ActionCharacter类，而在ActionCharacter类中是有fight的定义
    public void swim(){}
    public void fly(){}
    public  void climb(){}
}
public class Adventure {
    public static void t(CanFight x){x.fight();}
    public static  void u(CanSwim x){x.swim();}
    public static void v(CanFly x){x.fly();}
    public static void j(CanClimb x){x.climb();}
    public static void w(ActionCharacter x){x.fight();}
    public static void main(String[] args){
        Hero h = new Hero();
        //可以向上转型为每一个接口
        t(h);
        u(h);
        v(h);
        j(h);
        w(h);
    }
}
