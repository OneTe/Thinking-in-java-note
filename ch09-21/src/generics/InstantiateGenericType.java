package generics;
//在Erased.java中对创建一个new T()的尝试将无法实现，部分原因是擦除，另一个原因是编译器不能验证T具有默认(无参)构造器
//java中的解决方案是传递一个工厂对象，并使用他来创建新的实例，最便利的工厂对象就是Class对象
/**
 * Created by wangcheng  on 2017/9/21.
 */
class ClassAsFactory<T>{
    T x;
    public ClassAsFactory(Class<T> kind){
        try{
            x = kind.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
class Employee{}

public class InstantiateGenericType {
    public static void main(String[] args){
        ClassAsFactory<Employee> fe =
                new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        try{
            //能通过编译，但是Integer没有任何默认的构造器，ClassAsFactory<Integer>就失败了
            ClassAsFactory<Integer> fi =
                    new ClassAsFactory<>(Integer.class);
        }catch (Exception e){
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}
