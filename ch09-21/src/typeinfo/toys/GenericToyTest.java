package typeinfo.toys;

import com.sun.corba.se.spi.ior.ObjectKey;

/**
 * Created by wangcheng  on 2017/9/1.
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception{
        Class<FancyToy> ftClass = FancyToy.class;
        //Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        //Class<Toy> up2 = ftClass.getSuperclass();
        System.out.println(up);
        //Object obj = up.newInstance();//Only produces Objects
    }
}
