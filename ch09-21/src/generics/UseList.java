package generics;
//由于擦除，重载方法将产生相同的类型签名
/**
 * Created by wangcheng  on 2017/9/30.
 */
import java.util.*;

public class UseList<W,T> {
    //void f(List<T> v){}
    void f(List<W> v){}

    //提供不同方法可以了
    void f1(List<T> v){}
    void f2(List<W> v){}
}
