package innerclasses;
//局部内部类，在方法内创建一个完整的类
/**
 * Created by wangcheng on 2017/6/5.
 */
public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;
            private PDestination(String whereTo){
                label = whereTo;
            }
            public String readLabel(){return label;}
        }
        return new PDestination(s);
    }
    public static void main(String[] args){
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
}
