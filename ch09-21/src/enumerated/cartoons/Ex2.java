package enumerated.cartoons;

import java.util.Random;
/****************** Exercise 2 *****************
 * Instead of implementing an interface, make
 * next() a static method. What are the benefits
 * and drawbacks of this approach?
 ***********************************************/
/**
 * Created by wangcheng  on 2017/12/14.
 */
enum CartoonCharacter1  {
    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
    private  Random rand = new Random(47);

    public  CartoonCharacter1 next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class Ex2 {
    public static void printNext(CartoonCharacter1 cc){
        System.out.print(cc.next() + ", ");
    }
    public static void main(String[] args){
        CartoonCharacter1 cc = CartoonCharacter1.BOB;
        for(int i = 0 ; i < 10; i++)
            printNext(cc);
    }
}
