/**
 * Created by wangcheng on 2017/3/7.
 */
public class Ex22 {
    enum Cash{
        ONE,TWO,THREE,FOUR,FIVE,SIX
    }
    Cash cash;
    public Ex22(Cash cash){
        this.cash=cash;
    }
    public void printscript(){
        System.out.print("this script is:");
        switch (cash){
            case ONE:   System.out.println("one dollar");break;
            case TWO:   System.out.println("two dollar");break;
            case THREE: System.out.println("three dollar");break;
            case FOUR:  System.out.println("four dollar");break;
            case FIVE:  System.out.println("five dollar");break;
            case SIX:   System.out.println("six dollar");break;
            default:    break;
        }
    }
    public static void main(String[] args){
        Cash cash;
        Ex22
                on = new Ex22(Cash.ONE),
                tw = new Ex22(Cash.TWO),
                th = new Ex22(Cash.THREE),
                fo = new Ex22(Cash.FOUR),
                fi = new Ex22(Cash.FIVE),
                si = new Ex22(Cash.SIX);
        on.printscript();
        tw.printscript();
        th.printscript();
        fo.printscript();
        fi.printscript();
        si.printscript();

    }
}
