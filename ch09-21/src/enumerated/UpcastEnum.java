package enumerated;
//No value() method of you upcast an enum
/**
 * Created by wangcheng  on 2017/12/13.
 */
enum Search{HITHER,YOU}

public class UpcastEnum {
    public static void main(String[] args){
        Search[] vals = Search.values();
        Enum e = Search.HITHER;
        //e.values()//No values() in Enum
        //getEnumConstants()是class上的方法
        for(Enum en : e.getClass().getEnumConstants())
            System.out.println(en);
    }
}
