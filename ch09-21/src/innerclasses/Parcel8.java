package innerclasses;
//这个例子展示了基类需要的一个有参数的构造器

/**
 * Created by wangcheng on 2017/6/8.
 */
//public class Parcel8 {
//    public Wrapping wrapping(int x){
//        return new Wrapping(x) {
//            public int value(){
//                return super.value() * 47;
//            }
//        };
//    }
//    public static void main(String[] args){
//        Parcel8 p = new Parcel8();
//        Wrapping w =  p.wrapping(10);
//    }
//}
public class Parcel8{
    public class MyWrapping extends Wrapping{
        private int i;
        MyWrapping(int x){super(x);i = x;}
        public int value(){
            System.out.println(i);
            return  i;
        }
    }
    public MyWrapping myWrapping(int x){
        return new MyWrapping(x);
    }
    public static void main(String[] args){
        Parcel8 p = new Parcel8();
        Wrapping w = p.myWrapping(10);
        w.value();
    }
}

