package concurrency;
//A Runnable containing its own driver Thread.
//start()是在构造器中调用的，但是在构造器中启动线程可能会有问题
//因为另一个任务可能会在构造器结束之前开始执行，这意味着该任务能够访问处于不稳定状态的对象
//这是优选Executor而不是显式地创建Thread对象的另一个原因
/**
 * Created by wangcheng  on 2018/1/5.
 */
public class SelfManaged implements Runnable{
    private int countDown = 5;
    private Thread t = new Thread(this);
    public SelfManaged(){t.start();}
    public String toString(){
        return Thread.currentThread().getName() +
                "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if(--countDown == 0)
                return;
        }
    }
    public static void main(String[] args){
        for(int i = 0; i < 5;i++)
            new SelfManaged();
    }
}
