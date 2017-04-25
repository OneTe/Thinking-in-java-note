package Interfaces.filters;

/**
 * Created by wangcheng on 2017/4/25.
 */

public class Waveform {
    private static long counter;
    private final long id = counter++;
    public String toString(){return "Waveform " + id;}

}
