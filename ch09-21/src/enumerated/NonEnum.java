package enumerated;
//可以对不是枚举的类掉调用getEnumConstants()方法，只不过这方法返回null
/**
 * Created by wangcheng  on 2017/12/14.
 */
public class NonEnum {
    public static void main(String[] args){
        Class<Integer> intClass = Integer.class;
        try{
            for(Object en : intClass.getEnumConstants())
                System.out.println(en);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
