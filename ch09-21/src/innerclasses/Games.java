package innerclasses;
// Interface/Games的匿名类方式
/**
 * Created by wangcheng on 2017/6/21.
 */

interface Game{
    boolean move();
}
interface GameFactory{
    Game getGame();
}
class Checkers implements Game{
    private int moves = 0;
    private static final int MOVES = 3;
    public boolean move(){
        System.out.println("Checkers move " + moves);
        return ++moves !=MOVES;
    }
    public static GameFactory factory =
            new GameFactory() {
                @Override
                public Game getGame() {
                    return new Checkers();
                }
            };
}
class Chess implements Game{
    private int moves = 0;
    private static final int MOVES = 4;
    public boolean move(){
        System.out.println("Chess move " + moves);
        return ++moves !=MOVES;
    }
    public static GameFactory factory =
            new GameFactory() {
                @Override
                public Game getGame() {
                    return new Chess();
                }
            };
}
public class Games {
    public static void playGame(GameFactory factory){
        Game s = factory.getGame();
        //System.out.println("jaa");
        while (s.move())
            ;
    }
    public static void main(String[] args){
        playGame(Checkers.factory);
        playGame(Chess.factory);
    }
}