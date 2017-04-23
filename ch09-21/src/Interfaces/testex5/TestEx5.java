package Interfaces.testex5;
import Interfaces.test.Interface;
/**
 * Created by wangcheng on 2017/4/21.
 */
class Si implements Interface{
    	// Error: cannot assign weaker access to public methods:
        // void sayOne() { System.out.println("one"); } // implies package *							// access
        // protected void sayTwo() { System.out.println("two"); }
        // private void sayThree() { System.out.println("three"); }
        // must be maintained public:
    public void sayOne(){}
    public void sayTwo(){}
    public void sayThree(){}
}
public class TestEx5 {
    public static void main(){
        Si s = new Si();
        s.sayOne();
        s.sayTwo();
        s.sayThree();
    }
}
