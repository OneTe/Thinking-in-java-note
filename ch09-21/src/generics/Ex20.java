package generics;


/**
 * Created by wangcheng  on 2017/9/21.
 */
interface Learn{
    void read();
    void listen();
}
class HardLearn implements Learn{
    public void read(){System.out.println("You need to read five news every day!");}
    public void listen(){System.out.println("You need to listen two dialogs every day!");}
    public void speak(){System.out.println("You must speaking every morning!");}
}
public class Ex20 {
    public   <T extends Learn> void study(T s){
        s.read();
        s.listen();
    }
    public static void main(String[] args){
        HardLearn hl = new HardLearn();
        Ex20 e = new Ex20();
        e.study(hl);
    }
}
