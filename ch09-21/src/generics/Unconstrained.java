package generics;

/**
 * Created by wangcheng  on 2017/10/10.
 */
class Other{}
class BasicOther extends BasicHolder<Other>{}
public class Unconstrained {
    public static void main(String[] args){
        BasicOther b = new BasicOther(), b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}
