package generics;


/**
 * Created by wangcheng  on 2017/9/15.
 */
class Automobile{}
public class Holder1 {
    private Automobile a;
    public Holder1(Automobile a){ this.a = a;}
    Automobile get(){return a;};
}