package concurrency;

/**
 * Created by wangcheng  on 2018/1/10.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    //Allow this to be canceled:
    public void cancel(){canceled = true;}
    public boolean isCanceled(){return canceled;}
}
