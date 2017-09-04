package typeinfo;

/**
 * Created by wangcheng  on 2017/9/1.
 */
public class BoundedClassReferences {
    public static void main(String[] args){
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
