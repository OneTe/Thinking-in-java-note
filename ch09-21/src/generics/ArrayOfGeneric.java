package generics;
//成功创建泛型数组的唯一方式就是创建一个被擦除类型的新数组，然后对其进行转型。
/**
 * Created by wangcheng  on 2017/9/22.
 */
class Generic<T>{}
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;
    public static void main(String[] args){
        //Compiles:produces ClassCastException
        //!gia = (Generic<Integer>[])new Object[SIZE];
        //Runtime type is the raw (erased) type:
        gia = (Generic<Integer>[])new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();
        //!gia[1] = new Object();//Compile-time error
        //Discovers type mismatch at compile time:
        //!gia[2] = new Generic<Double>();
    }
}
