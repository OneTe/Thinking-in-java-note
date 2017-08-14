package holding;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

/**
 * Created by wangcheng on 2017/8/14.
 */
public class EnvironmentVariables {
    public static void main(String[] args){
        //System.getenv()返回一个Map，entrySet()产生一个由Map.Entry元素构成的Set，并且这个Set是一个Iterable，
        //所以可以用于foreach
        for(Map.Entry entry : System.getenv().entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
