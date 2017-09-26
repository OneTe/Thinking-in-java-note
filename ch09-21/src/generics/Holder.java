package generics;
//可以看出编译器只关注传递进来和要返回的对象类型，它并不会分析代码，以查看是否执行了任何实际的写入和读取操作
/**
 * Created by wangcheng  on 2017/9/26.
 */
public class Holder<T> {
    private T value;
    public Holder(){}
    public Holder(T val){value = val;}
    public void set(T val){value = val;}
    public T get(){return value;}
    public boolean equals(Object obj){
        return value.equals(obj);
    }
    public static void main(String[] args){
        Holder<Apple> Apple = new Holder<Apple>(new Apple());
        Apple d = Apple.get();
        Apple.set(d);
        //Holder<Fruit> Fruit = Apple; //Cannot upcast
        Holder<? extends Fruit> fruit = Apple;//OK
        Fruit p = fruit.get();
        d = (Apple)fruit.get();//Returns 'Object'
        try {
            Orange c = (Orange) fruit.get();//No warning
        }catch (Exception e){
            System.out.println(e);
        }
        //fruit.set(new Apple()); can't call set
        System.out.println(fruit.equals(d));
    }
}
