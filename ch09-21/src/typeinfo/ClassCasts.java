package typeinfo;
//the cast()接受参数对象，并将其转型为Class引用的类型
/**
 * Created by wangcheng  on 2017/9/4.
 */
class Building{}
class House extends Building{}
public class ClassCasts {
    public static void main(String[] args){
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House)b;
    }
}
