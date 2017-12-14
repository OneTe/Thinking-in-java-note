package enumerated;

import net.mindview.util.Enums;

/**
 * Created by wangcheng  on 2017/12/14.
 */

enum Activity{
    SITTING, LYING, STANDING, HOPPING,
    RUNNING, DODGING, JUMPING, FALLING, FLYING
}
public class RandomTest {
    public static void main(String[] args){
        for(int i = 0;i < 20; i++)
            System.out.print(Enums.random(Activity.class) + " ");
    }
}
