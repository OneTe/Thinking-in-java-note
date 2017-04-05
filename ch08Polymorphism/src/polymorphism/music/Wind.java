package polymorphism.music;

/**
 * Created by wangcheng on 2017/4/5.
 */
public class Wind extends Instrument {
    public void play(Note n){
        System.out.println("Wind.play() " + n);
    }
}
