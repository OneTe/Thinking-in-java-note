package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 21, page 367
/* Create an interface that contains a nested class that has a static method that
* calls the methods of your interface and displays the results. Implement your
* interface and pass an instance of your implementation to the method.
*/
/**
 * Created by wangcheng on 2017/6/29.
 */
interface T{
    String say();
    class Hello{
        public static void f(T i){
           System.out.println(i.say());
        }
    }
}
public class Ex21 implements T{
    public String say(){
        return "Hello!";
    }
    public static void main(String[] args){
        Ex21 e = new Ex21();
        T.Hello.f(e);
    }
}
