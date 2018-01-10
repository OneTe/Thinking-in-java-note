package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangcheng  on 2018/1/10.
 */
public class NaiveExceptionHandling {
    public static void main(String[] args){
        try {
            ExecutorService exec =
                    Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        }catch (RuntimeException e){
            //This statement will NOT execute!
            System.out.println("Exception has been handled!");
        }
    }
}
