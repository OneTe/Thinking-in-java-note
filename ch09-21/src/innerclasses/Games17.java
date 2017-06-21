package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 17, page 364
/* Modify the solution to Exercise 19 from the Interfaces chapter to use
* anonymous inner classes.
* (Exercise 19, Interfaces: Create a framework using Factory Methods
* that performs both coin tossing and dice tossing.
*/

import java.util.Random;

/**
 * Created by wangcheng on 2017/6/21.
 */
interface Games2{void play();}
interface Games2Factory{Games2 getGame();}
class CoinToss implements Games2{
    Random rand = new Random();
    public void play(){
        System.out.print("Toss coin: ");
        switch(rand.nextInt(2)){
            case 0: System.out.println("Heads"); return;
            case 1: System.out.println("Tails"); return;
            case 2: System.out.println("OnEdge");return;
        }
    }
    public static Games2Factory factory =
            new Games2Factory() {
                @Override
                public Games2 getGame() {
                    return new CoinToss();
                }
            };
}
class DiceThrow implements Games2{
    Random rand = new Random();
    public void play(){
        System.out.println("Throw Dice: " + (rand.nextInt(6) + 1));
    }
    public static Games2Factory factory =
            new Games2Factory() {
                @Override
                public Games2 getGame() {
                    return new DiceThrow();
                }
            };
}
public class Games17 {
    public static void playGames2(Games2Factory gf){
        Games2  g = gf.getGame();
        g.play();
    }
    public static void main(String[] args){
        playGames2(CoinToss.factory);
        playGames2(DiceThrow.factory);
    }
}

//interface Games1{
//    void play();
//}
//interface Games1Factory{
//    Games1 getGame();
//}
//class CoinToss implements Games1{
//    Random rand = new Random();
//    public void play(){
//        System.out.print("Toss coin: ");
//        switch(rand.nextInt(2)){
//            case 0: System.out.println("Heads"); return;
//            case 1: System.out.println("Tails"); return;
//            case 2: System.out.println("OnEdge"); return;
//        }
//    }
//}
//class CoinTossFactory implements Games1Factory{
//    public Games1 getGame(){
//        return new CoinToss();
//    }
//}
//class DiceThrow implements Games1{
//    Random rand = new Random();
//    public void play(){
//        System.out.println("Throw Dice: " + (rand.nextInt(6) + 1));
//    }
//}
//class DiceThrowFactory implements Games1Factory{
//    public Games1 getGame(){
//        return new DiceThrow();
//    }
//}
//public class Games19 {
//    public static void playGames1(Games1Factory gf){
//        Games1 g = gf.getGame();
//        g.play();
//    }
//    public static void main(String[] args){
//        playGames1(new CoinTossFactory());
//        playGames1(new DiceThrowFactory());
//    }
//}
