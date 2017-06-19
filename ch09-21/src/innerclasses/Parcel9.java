package innerclasses;
//在匿名类中定义字段时，能够对其进行初始化操作
/**
 * Created by wangcheng on 2017/6/13.
 */
public class Parcel9 {
    //在JDK1.8之后不再需要显示的声明为final，因为这种情况下这个局部变量默认是final的，这是编译器为我们做的，这是JDK1.8的新特性，所以前面的结论仍然成立）
    //Argument must be final to use inside anonymous inner class
    public Destination destination( final String dest) {
        return new Destination() {
            private String label;

            public String readLabel() {
                return label;
            }

        };
    }
    public static void main(String[] args){
        Parcel9 p = new Parcel9();
       Destination d = p.destination("Tasmania");
     //   System.out.println(d.readLabel());
    }
}
