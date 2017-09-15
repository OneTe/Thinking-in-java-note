package net.mindview.util;
//2维元组，能够持有两个对象
/**
 * Created by wangcheng  on 2017/9/15.
 */
public class TwoTuple<A,B> {
    public final A first;
    public final B second;
    public TwoTuple(A a,B b){
        first = a;
        second = b;
    }
    public String toString(){
        return "(" + first + ", " + second + ")";
    }
}
