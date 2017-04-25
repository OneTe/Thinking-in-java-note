package Interfaces.filters;

/**
 * Created by wangcheng on 2017/4/25.
 */
public class BandPass extends Filter {
    double lowCutoff,highCutoff;
    public BandPass(double lowCut,double highCut){
        lowCutoff = lowCut;
        highCutoff = highCut;
    }
    public Waveform process(Waveform input){return input;}
}
