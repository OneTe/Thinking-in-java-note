package generics;

import net.mindview.util.RandomGenerator;

/**
 * Created by wangcheng  on 2017/9/28.
 */
public class Holders30 {
    public static void main(String[] args){
        Holder<Character> charHolder = new Holder<>();
        Holder<Byte> byteHolder = new Holder<>();
        Holder<Short> shortHolder = new Holder<>();
        Holder<Integer> intHolder = new Holder<>();
        Holder<Long> longHolder = new Holder<>();
        Holder<Float> floatHolder = new Holder<>();
        Holder<Double> doubleHolder = new Holder<>();
        charHolder.set('a');
        System.out.print(charHolder.get() + ", ");
        System.out.println(charHolder.get().getClass());
        char c = charHolder.get();
        System.out.println("char c = charHolder.get() = " + c);
    }
}
