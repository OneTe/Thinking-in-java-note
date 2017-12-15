package enumerated.menu;
//Basics of EnumMaps
/**
 * Created by wangcheng  on 2017/12/15.
 */
import enumerated.AlarmPoints;

import java.util.EnumMap;
import java.util.Map;

import static enumerated.AlarmPoints.*;

interface Command{void action();}
public class EnumMaps {
    public static void main(String[] args){
        EnumMap<AlarmPoints,Command> em =
                new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("KITCHEN fire!");
            }
        });
        em.put(BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("BATHROOM alert!");
            }
        });
        for(Map.Entry<AlarmPoints,Command> e : em.entrySet()){
            System.out.println(e.getKey() + ": ");
            e.getValue().action();
        }
        try{
            em.get(UTILITY).action();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
