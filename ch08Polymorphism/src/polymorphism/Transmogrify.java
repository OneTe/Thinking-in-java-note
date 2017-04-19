package polymorphism;
//Dyamically changing the behavior of an object
//via compostion(the "State" design pattern).
/**
 * Created by wangcheng on 2017/4/19.
 */
class Actor{
    public void act(){}
}
class HappyActor extends Actor{
    public void act(){ System.out.println("HappyActor");}
}
class SadActor extends Actor{
    public void act(){ System.out.println("SadActor");}
}
class Stage{
    private Actor actor = new HappyActor();
    public void change(){ actor = new SadActor();}
    public void performPlay(){actor.act();}
}
public class Transmogrify {
    public static void main(String[] args){
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
