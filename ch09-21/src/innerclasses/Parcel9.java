package innerclasses;
//在匿名类中定义字段时，能够对其进行初始化操作
/**
 * Created by wangcheng on 2017/6/13.
 */
public class Parcel9 {
    //Argument must be final to use inside anonymous inner class
    public Destination destination( String dest) {
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
