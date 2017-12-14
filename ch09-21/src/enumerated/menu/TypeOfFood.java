package enumerated.menu;

/**
 * Created by wangcheng  on 2017/12/14.
 */
import static enumerated.menu.Food.*;

public class TypeOfFood {
    public static void main(String[] args){
        Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.CAPPUCCINO;
    }
}
