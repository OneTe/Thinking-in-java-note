package typeinfo;

/**
 * Created by wangcheng  on 2017/9/1.
 */
import java.util.*;
class CounterInteger{
    private static long counter;
    private final long id = counter++;
    public String toString(){return Long.toString(id);}
}
public class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type){
        this.type = type;
    }
    public List<T> create(int nElements){
        List<T> result = new ArrayList<>();
        try{
            for(int i = 0;i < nElements;i++){
                result.add(type.newInstance());
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        return result;
    }
    public static void main(String[] args){
        FilledList<CounterInteger> fl = new FilledList<>(CounterInteger.class);
        System.out.println(fl.create(15));
    }
}
