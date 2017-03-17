/**
 * Created by wangcheng on 2017/3/14.
 * 如果没有默认的基类构造器，或想调用一个带参数的基类构造器，就必须用关键字super显式的编写调用基类构造器的语句
 *
 */
class Game{
    Game(){
        System.out.println("hah");
    }
    Game(int i){
        System.out.println("Game Constructor");
    }
}
class BoardGame extends Game{
    BoardGame(int i ){
        super(i);
        System.out.println("BoardGame Constructor");
    }
}
public class Chess extends BoardGame{
    Chess(){
        super(11);
        System.out.println("Chess Constructor");
    }
    public static void main(String[] args){
        Chess x = new Chess();
    }
}
