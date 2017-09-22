package generics;
//因为有了擦除，数组的运行时类型就只能是Object[],如果立即将其转型为T[]，那么在编译期该数组的实际类型就将丢失（GenericArray.java）
//而编译器可能会错过某些潜在的错误检查。正因为这样，最好是在集合内部使用Object[]，然后在使用数组元素时，添加一个对T的转型
//如下面get(),然而调用rep()，它还是尝试将Object[]转型为T[]，这仍旧是不正确的，底层数组类型，它只能是Object[]
/**
 * Created by wangcheng  on 2017/9/22.
 */
public class GenericArray2<T> {
    private Object[] array;
    public GenericArray2(int sz){
        array = new Object[sz];
    }
    public void put(int index ,T item){
        array[index] = item;
    }
    @SuppressWarnings("unchecked")
    public T get(int index){return (T)array[index];}
    @SuppressWarnings("unchecked")
    public T[] rep(){
        return (T[])array;
    }
    public static void main(String[] args){
        GenericArray2<Integer> gai =
                new GenericArray2<>(10);
        for(int i =0;i<10;i++){
            gai.put(i,i);
        }
        for(int i =0;i<10;i++){
            System.out.print(gai.get(i) + " ");
        }
        System.out.println();
        try{
            Integer[] ia = gai.rep();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
