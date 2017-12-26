package concurrency;

//SingleThreadExecutor会序列化所有提交给他的任务
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangcheng  on 2017/12/26.
 */
public class SingleThreadExecutor {
    public static void main(String[] args){
        ExecutorService exec =
                Executors.newSingleThreadExecutor();
        for(int i = 0;i < 5;i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
