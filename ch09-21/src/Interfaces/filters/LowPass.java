package Interfaces.filters;

/**
 * Created by wangcheng on 2017/4/25.
 */
public class LowPass extends Filter{
    double cutoff;
    public LowPass(double cutoff){this.cutoff = cutoff;}
    public Waveform process(Waveform input){
        return input;
    }
}
