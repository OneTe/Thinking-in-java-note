import java.util.Random;

/**
 * Created by wangcheng on 2017/3/22.
 * final域的情况,既是static又是final的域将用大写字母表示，并使用下划线分隔各个单词
 */
class Value{
    int i;
    public Value(int i){
        this.i = i;
    }
}
public class FinalData {
    private static Random rand = new Random(47);
    private String id;
    public FinalData(String id){
        this.id = id;
    }
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    public static final int VALUE_THREE = 39;
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    //Arrays:
    private final int[] a = {1,2,3,4,5,6};
    public String toString(){
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }
    public static void main(String[] args){
        FinalData fd1 = new FinalData("fd1");
        //!fd1.valueOne++;//Error,can't change value

        //对于对象引用,final使引用不变，一旦引用被初始化指向一个对象，就无法再把它改为指向另一个对象。然而，对象其自身却是可以被修改的
        fd1.v2.i++; //Object isn't constant!
        fd1.v1 = new Value(9);//Ok ,not final
        for(int i = 0;i<fd1.a.length;i++){
            fd1.a[i]++;//Object isn't constant!
        }
        //!fd1.v2 = new Value(0);  //Error ,can't
        //!fd1.VAL_3 = new Value(1); //change reference
        //!fd1.a = new int[3];
        System.out.println(fd1);
        System.out.println("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        System.out.println(fd1);
        System.out.println(fd2);
    }
}
