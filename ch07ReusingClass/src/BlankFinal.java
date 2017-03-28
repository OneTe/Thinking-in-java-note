/**
 * Created by wangcheng on 2017/3/28.
 * blank final
 * 必须在域的定义处或者每个构造器中用表达式对final进行赋值
 */
class Poppet{
    private int i;
    Poppet(int ii){
        i =ii;
    }
}
public class BlankFinal {
    private final int i=0; //initialized final
    private final int j; // Blank final
    private final Poppet p; //Blank final reference
    //Blank finals MUST be initialized in the constructor
    public BlankFinal(){
        j =1;
        p =new Poppet(1);
    }
    public BlankFinal(int x){
        j = x;
        p = new Poppet(x);
    }
    public static void main(String[] args){
        new BlankFinal();
        new BlankFinal(47);
    }
}
