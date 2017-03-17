/**
 * Created by wangcheng on 2017/3/14.
 * Modify Detergent.java so that is uses delegation.
 */
class Cleanser1{
    private String s = "Cleanser";
    public void append(String a ){ s +=a;}
    public void dilute(){append(" dilute()");}
    public void apply(){append(" apply()");}
    public void scrub(){append(" scrub()");}
    public String toString(){return s;}

    public static void main(String[] args){
        Cleanser x = new Cleanser();
        System.out.println(x);
    }
}
public class Ex11 {
    private String s = "DetergentDelegation";
    private Cleanser1 c = new Cleanser1();
    public void append(String a) { s += a; }
    // two methods delegated entirely to Cleanser c:
    public void dilute() {
        c.dilute();
    }
    public void apply() {
        c.apply();
    }
    // method delegated in part to Cleanser c:
    public void scrub() {
        append(" DetergentDelegation.scrub()");
        c.scrub();
    }
    public void foam() { append(" foam()"); }
    public String toString() { return s + " " + c; }
    public static void main(String[] args) {
        Ex11 x = new Ex11();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}
