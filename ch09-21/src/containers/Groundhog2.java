package containers;
//A class that's used as a key in a HashMap
//must override hashcode() and equals().
/**
 * Created by wangcheng  on 2017/11/14.
 */
public class Groundhog2 extends Groundhog{
    public Groundhog2(int n){ super(n);}
    public int hashCode() {return number;}
    public boolean equals(Object o){
        return o instanceof Groundhog2 && (number ==((Groundhog2)o).number);
    }
}
