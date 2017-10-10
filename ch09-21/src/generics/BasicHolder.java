package generics;


/**
 * Created by wangcheng  on 2017/10/10.
 */
public class BasicHolder<T> {
    T element;
    void set(T arg){element = arg;}
    T get(){return element;}
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}
