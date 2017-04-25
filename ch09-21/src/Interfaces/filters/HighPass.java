package Interfaces.filters;

/**
 * Created by wangcheng on 2017/4/25.
 */
public class HighPass extends Filter{
    double cutoff;
    public HighPass(double cutoff){this.cutoff = cutoff;}
    public Waveform process(Waveform input){return input;}
}
