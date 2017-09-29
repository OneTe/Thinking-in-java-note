package generics;
//Hourly不能编译，因为擦除会将Payable<Employee1>与Payable<Hourly>简化为相同的类Payable
//但是把两个的泛型参数都移除了，这段代码却可以编译
/**
 * Created by wangcheng  on 2017/9/29.
 */
interface Payable<T>{}
class Employee1 implements Payable<Employee1>{}
//class Hourly extends Employee1 implements Payable<Hourly>{}

public class MultipleInterfaceVariants {
}
