package exceptions;

/**
 * Created by wangcheng on 2017/8/23.
 */
public class Switch {
    private boolean state = false;
    public boolean read(){return state;}
    public void on(){
        state = true;
        System.out.println(this);
    }
    public void off(){
        state = false;
        System.out.println(this);
    }
    public String toString(){
        return state ? "On" : "Off";
    }
}
