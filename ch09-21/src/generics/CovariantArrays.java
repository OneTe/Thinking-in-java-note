package generics;
//在编译期不会遇到任何问题，但在运行期时就知道它处理的是Apple[]，这样不是Apple[]类型都会抛出异常
/**
 * Created by wangcheng  on 2017/9/26.
 */
class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}
public class CovariantArrays {
    public static void main(String[] args){
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        //Runtime type is Apple[],not Fruit[]
        try {
            fruits[0] = new Fruit();
        }catch (Exception e){//ArrayStoreException
            System.out.println(e);
        }
        try {
            fruits[0] = new Orange();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
