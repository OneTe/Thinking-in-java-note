package enumerated;

/**
 * Created by wangcheng  on 2017/12/20.
 */
import java.util.*;

public enum  Input {
    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
    TOOTHPASTE(200),CHIPS(75),SODA(100),SPAP(50),
    ABORT_TRANSACTION{
        public int amount(){//Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP{//This must be the last instance.
        public int amount(){
            throw new RuntimeException("SHOUT_DOMN.amount()");
        }
    };
    int value;
    Input(int value){this.value = value;}
    Input(){}
    int amount(){return value;}
    static Random rand = new Random(47);
    public static Input randomSelection(){
        //Don't include STOP:
        return values()[rand.nextInt(values().length - 1)];
    }
}
