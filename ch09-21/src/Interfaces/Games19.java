package Interfaces;
// TIJ4 Chapter Interfaces, Exercise 19, page 342
/* Create a framework using Factory Methods that performs both coin
* tossing and dice tossing.
*/

import java.util.Random;

/**
 * Created by wangcheng on 2017/5/17.
 */
interface Games1{
    void play();
}
interface Games1Factory{
    Games1 getGame();
}
class CoinToss implements Games1{
    Random rand = new Random();
    public void play(){
        System.out.print("Toss coin: ");
        switch(rand.nextInt(2)){
            case 0: System.out.println("Heads"); return;
            case 1: System.out.println("Tails"); return;
            case 2: System.out.println("OnEdge"); return;
        }
    }
}
class CoinTossFactory implements Games1Factory{
    public Games1 getGame(){
        return new CoinToss();
    }
}
class DiceThrow implements Games1{
    Random rand = new Random();
    public void play(){
        System.out.println("Throw Dice: " + (rand.nextInt(6) + 1));
    }
}
class DiceThrowFactory implements Games1Factory{
    public Games1 getGame(){
        return new DiceThrow();
    }
}
public class Games19 {
    public static void playGames1(Games1Factory gf){
        Games1 g = gf.getGame();
        g.play();
    }
    public static void main(String[] args){
        playGames1(new CoinTossFactory());
        playGames1(new DiceThrowFactory());
    }
}
