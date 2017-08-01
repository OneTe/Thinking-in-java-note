package holding;
// TIJ4 Chapter Holding, Exercise 8, page 409
// Modify Exercise 1 so it uses an Iterator to move through the List while
// calling hop().
/**
 * Created by wangcheng on 2017/8/1.
 */
import java.util.*;

class Gerbil1{
    private int gerbilNumber;
    Gerbil1(int num){
        gerbilNumber = num;
    }
    public void hop(){
        System.out.println(gerbilNumber + " jump");
    }

}
public class Ex8 {
    public static void main(String[] args){
        ArrayList<Gerbil1> gerbil1s = new ArrayList<>();
        gerbil1s.add(new Gerbil1(1));
        gerbil1s.add(new Gerbil1(2));
        gerbil1s.add(new Gerbil1(3));

        Iterator<Gerbil1> it = gerbil1s.iterator();
        while (it.hasNext()){
            it.next().hop();
        }
    }
}
