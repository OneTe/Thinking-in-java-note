package Interfaces.filters;

/**
 * Created by wangcheng on 2017/4/25.
 */
public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input){return input; }
}
