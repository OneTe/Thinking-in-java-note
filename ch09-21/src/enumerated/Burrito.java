package enumerated;

//使用static import导入
import static enumerated.Spiciness.*;
/**
 * Created by wangcheng  on 2017/12/13.
 */

public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree){this.degree = degree;}
    public String toString(){return "Burrito is " + degree;}
    public static void main(String[] args){
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}