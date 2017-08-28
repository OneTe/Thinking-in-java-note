package exceptions;
// TIJ4 Chapter Exceptions, Exercise 29, page 500
/* Modify all the exception types in StormyInning.java so that they extend
* RuntimeException, and show that no exception specifications or try blocks
* are necessary. Remove the '//!' comments and show how the methods can be
* compiled without specifications.
*/
/**
 * Created by wangcheng  on 2017/8/28.
 */
class BaseballException29 extends RuntimeException{}
class Foul29 extends RuntimeException{}
class Strike29 extends RuntimeException{}

abstract class Inning29{
    public Inning29(){}
    public void event(){}
    public abstract void atBat();
    public void walk(){}
}

class StormException29 extends RuntimeException{}
class RainedOut29 extends RuntimeException{}
class PopFoul29 extends RuntimeException{}

interface Storm29{
    public void event();
    public void rainHard();
}
public class StormyInning29 extends Inning29 implements Storm29{
    public StormyInning29(){}
    public StormyInning29(String s){}
    public void walk(){}
    public void event(){}
    public void rainHard(){}
    public void atBat(){}
    public static void main(String[] args){
        StormyInning29 si = new StormyInning29();
        si.atBat();
        Inning29 i = new StormyInning29();
        i.atBat();
    }
}
