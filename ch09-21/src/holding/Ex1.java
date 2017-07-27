package holding;

/**
 * Created by wangcheng on 2017/7/27.
 */
import java.util.*;
class Gerbil{
    private int gerbilNumber;
    Gerbil(int num){
        gerbilNumber = num;
    }
    public void hop(){
        System.out.println(gerbilNumber + " jump");
    }
}
public class Ex1 {
    public static void main(String[] args){
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        gerbils.add(new Gerbil(1));
        gerbils.add(new Gerbil(2));
        gerbils.add(new Gerbil(3));
        for(Gerbil g : gerbils){
            g.hop();
        }
    }
}
