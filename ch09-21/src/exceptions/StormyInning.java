package exceptions;
//Overridden methods may throw only the exceptions
//specified in their base-class versions, or exceptions
//derived from the base-class exceptions
/**
 * Created by wangcheng on 2017/8/24.
 */
class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning{
    public Inning() throws BaseballException{}
    public void event() throws BaseballException{
        //Don't actually have to thrown anything.
    }
    public abstract void atBat() throws Strike,Foul;
    public void walk(){} //Throws no checked exceptions
}
class StormException extends Exception{}
class RaineOut extends StormException{}
class PopFoul extends Foul{}

interface Storm{
    public void event() throws RaineOut;
    public void rainHard() throws RaineOut;
}

public class StormyInning extends Inning implements Storm{
    //OK to add new exceptions for constructors, but you
    //must deal with the base constructor exceptions:
    public StormyInning() throws RaineOut,BaseballException{}
    public StormyInning(String s) throws Foul,BaseballException{}
    //Regular methods must conform to base class:
    //!public void walk() throws PopFoul{}
    //Interface cannot add exception to existing methods from the base class:
    //!public void event() throws RaineOut{}

    //if the method doesn't already exist in the base class .the exception is ok:
    public void rainHard() throws RaineOut{}
    public void event(){}
    public void atBat() throws PopFoul{}
    public static void main(String[] args){
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        }catch (PopFoul e){
            System.out.println("Pop foul");
        }catch (RaineOut e){
            System.out.println("Rained out");
        }catch (BaseballException e){
            System.out.println("Generic baseball exception");
        }
        //strike not thrown in derived version.
        try {
            //what happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
        }catch (Strike e){
            System.out.println("Strike");
        }catch (Foul e){
            System.out.println("Foul");
        }catch (RaineOut e){
            System.out.println("Rained out");
        }catch (BaseballException e){
            System.out.println("Generic baseball exception");
        }
    }
}
