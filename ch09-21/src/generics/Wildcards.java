package generics;
//Exploring the meaning of wildcards

import com.sun.corba.se.spi.ior.ObjectKey;

/**
 * Created by wangcheng  on 2017/9/27.
 */
public class Wildcards {
    //Raw argument:
    static void rawArgs(Holder holder, Object arg){
       // holder.set(arg);//Warning
       // holder.set(new Wildcards());//warning
        //can't do this ,don't hava any 'T'
        //T t = holder.get();
        //ok,but type of information has been lost:
        Object obj = holder.get();
    }
    static void unboundedArg(Holder<?> holder,Object arg){
        //holder.set(arg);//Error
        //holder.set(new Wildcards());//Error
        //can't do this ,don't hava any 'T'
        //T t = holder.get();
        //ok,but type of information has been lost:
        Object obj = holder.get();
    }
    static <T> T exact1(Holder<T> holder){
        T t = holder.get();
        return t;
    }
    static <T> T exact2(Holder<T> holder ,T arg){
        holder.set(arg);
        T t = holder.get();
        return t;
    }
    static <T> T wildSubtype(Holder<? extends T> holder,T arg){
        //holder.set(arg);//Error
        T t = holder.get();
        return t;
    }
    static <T> void wildSupertype(Holder<? super T> holder,T arg){
        holder.set(arg);
        //T t = holder.get();//Error
        //ok,but type of information has been lost:
        Object obj = holder.get();
    }
    public static void main(String[] args){
        Holder raw = new Holder<Long>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
    }
}
