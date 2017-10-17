package arrays;

/**
 * Created by wangcheng  on 2017/10/16.
 */
class A{}
public class Ex8<T> {
    @SuppressWarnings("unchecked")
    T[] a = (T[])new Object[2];// Compile warning: unchecked cast
    public static void main(String[] args){
        Object[] oa = new Object[3];
        int x =2;
        oa[2] = x;
    }
}
