package Interfaces.rodent;

import java.util.Random;

/**
 * Created by wangcheng on 2017/4/21.
 */
public class RandomRodentGenerator2 {
    private Random rand = new Random();
    public Rodent0 next(){
        switch (rand.nextInt(3)){
            default:
            case 0:return new Mouse0();
            case 1:return new Rat0();
            case 2:return new Squirrel0();
        }
    }
}
