/**
 * Created by wangcheng on 2017/3/21.
 * protected：包内或继承才能访问
 */
import reusing.ex15.*;

class DeviceFail {
    public static void main(String[] s) {
        BasicDevice fail = new BasicDevice();
        fail.showS();
        // fail.changeS("good-bye"); // cannot access protected method
    }
}

public class Ex15 extends BasicDevice {
    void changeBasic(String t) {
        super.changeS(t); // calls protected method
    }
    public static void main(String[] args) {
        Ex15 d = new Ex15();
        d.showS();
        d.changeBasic("Changed"); // derived class can access protected
        d.showS();
        DeviceFail.main(args);
    }
}
