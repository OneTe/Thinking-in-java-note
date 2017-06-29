package innerclasses;
//接口内部的类
// 嵌套类可以作为接口的一部分，放入接口中的任何类都自动是public和static的，甚至可以在内部类中实现其外围接口
/**
 * Created by wangcheng on 2017/6/27.
 */
public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface{
        public void howdy(){
            System.out.println("Howdy!");
        }
        public static void main(String[] args){
            new Test().howdy();
        }
    }
}
