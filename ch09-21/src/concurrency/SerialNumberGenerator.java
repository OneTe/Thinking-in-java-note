package concurrency;

/**
 * Created by wangcheng  on 2018/1/11.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber(){
        return serialNumber++;//Not Thread-safe
    }
}
