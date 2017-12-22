package enumerated;

/**
 * Created by wangcheng  on 2017/12/15.
 */
enum LikeClasses{
    WINKEN{void behavior(){System.out.println("Behavior1");}},
    BLINKEN{void behavior(){System.out.println("Behavior2");}},
    NOD{void behavior(){System.out.println("Behavior3");}};
    abstract void behavior();
}
public class NotClasses {
    //void f1(LikeClasses.WINKEN instance){}
}
