package generics;
//在java SE5之前，可以让这个类直接持有Object类型的对象
/**
 * Created by wangcheng  on 2017/9/15.
 */
public class Holder2 {
    private Object a;
    public Holder2(Object a){this.a = a;}
    public void set(Object a){this.a = a;}
    public Object get(){return a;}
    public static void main(String[] args){
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile)h2.get();
        h2.set("Not na Automobile");
        String s = (String)h2.get();
        h2.set(1);
        Integer x = (Integer)h2.get();
    }
}
