package net.mindview.util;
//设置守护进程
import java.util.concurrent.ThreadFactory;

/**
 * Created by wangcheng  on 2017/12/27.
 */
public class DaemonThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
