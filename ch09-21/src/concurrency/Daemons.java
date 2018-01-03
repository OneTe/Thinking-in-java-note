package concurrency;
//Daemon threads spawn other daemon threads

import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2018/1/3.
 */
class Daemon implements Runnable{
    private Thread[] t = new Thread[10];
    public void run(){
        for(int i = 0;i < t.length;i++){
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started, ");
        }
        for(int i = 0;i < t.length;i++){
            System.out.println("t[" + i + "].isDaemon() = " +
            t[i].isDaemon() + ", ");
        }
        while (true)
            Thread.yield();
    }
}
class DaemonSpawn implements Runnable{
    public void run(){
        while (true){
            Thread.yield();
        }
    }
}
public class Daemons {
    public static void main(String[] args) throws Exception{
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
        //Allow the Daemon threads to finish their startup processes;
        TimeUnit.SECONDS.sleep(1);
    }
}
