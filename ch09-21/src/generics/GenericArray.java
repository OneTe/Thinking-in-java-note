package generics;
//一个简单的泛型数组包装器
/**
 * Created by wangcheng  on 2017/9/22.
 */
public class GenericArray<T> {
    private T[] array;
    public GenericArray(int sz){
        array = (T[])new Object[sz];
    }
    public void put(int index,T item){
        array[index] = item;
    }
    public T get(int index){return array[index];}
    //Method that exposes the underlying representation:
    public T[] rep(){return array;}
    public static void main(String[] args){
        GenericArray<Integer> gai =
                new GenericArray<>(10);
        //This causes ac ClassCastException:
        //!Integer[] ia = gai.rep();
        //This is OK:
        Object[] oa = gai.rep();
    }
}
//和前面一样不能声明T[] array = new T[sz],因此创建了一个对象数组，然后将其转型