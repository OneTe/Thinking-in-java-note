/**
 * Created by wangcheng on 2017/3/21.
 * 向上转型
 */
class First{
    public void fi(){
        System.out.println("First.fi");
    }
    public void si(){
        System.out.println("First.si");
    }
}
class Second extends First{
    public  void fi(){
        System.out.println("Second.fi");
    }
    public void zi(){
        System.out.println("Second.fi");
    }
}
public class Upchange {
    public static void main(String[] args){
        First s = new Second();
        //s.zi(); 向上转型遗失和父类不同的方法
        s.fi();
        s.si();
    }
}
