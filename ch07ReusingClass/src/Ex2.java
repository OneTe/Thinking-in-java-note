/**
 * Created by wangcheng on 2017/3/14.
 */
public class Ex2 extends Detergent{
    public void scrub(){
        append("Ex2.scrub()");
        super.scrub();
    }
    public void sterilize(){
        append("sterilize()");
    }
    public static void main(String[] args){
        Ex2 e = new Ex2();
        e.scrub();
        e.sterilize();
        System.out.println(e);
    }
}
