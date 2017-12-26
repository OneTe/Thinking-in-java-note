package concurrency;

//Runnable是执行工作的独立任务，但是它不返回任何值，如果希望任务在完成时能够返回一个值
//那么可以实现Callable接口
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by wangcheng  on 2017/12/26.
 */
class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    public String call(){
        return "result of TaskWithResult " + id;
    }
}
public class CallableDemo {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results =
                new ArrayList<Future<String>>();
        for(int i = 0;i < 10;i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for(Future<String> fs : results)
            try{
                //get() blocks until completion:
                System.out.println(fs.get());
            }catch (InterruptedException e){
                System.out.println(e);
            }catch (ExecutionException e){
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
    }
}
