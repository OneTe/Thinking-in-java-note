package enumerated;
//Operations on EnumSets

import java.util.EnumSet;

import static enumerated.AlarmPoints.*;

/**
 * Created by wangcheng  on 2017/12/15.
 */
public class EnumSets {
    public static void main(String[] args){
        EnumSet<AlarmPoints> points =
                EnumSet.noneOf(AlarmPoints.class);//Empty set
        points.add(BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(points);

        points.removeAll(EnumSet.range(OFFICE1,OFFICE4));
        System.out.println(points);

        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
