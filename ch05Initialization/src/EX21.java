/**
 * Created by wangcheng on 2017/3/7.
 */
public class EX21 {
    enum Cash{
        ONE,TWO,THREE,FOUR,FIVE,SIX
    }
    public static void main(String[] args){
       // Cash cash;
        for(Cash s :Cash.values()){
            System.out.println(s + ".ordinal "+s.ordinal());
        }
    }
}
