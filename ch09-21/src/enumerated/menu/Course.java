package enumerated.menu;
//"枚举的枚举"，每一个Course的实例都将其对应的class对象作为构造器的参数
/**
 * Created by wangcheng  on 2017/12/14.
 */
import net.mindview.util.*;
public enum  Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Course(Class<? extends Food> kind){
        values = kind.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(values);
    }
}
