package Interfaces;
// TIJ4 Chapter Interfaces, Exercise 3, page 315
/* Create a base class with an abstract print() method that is overridden in a
* derived class. The overridden version of the method prints the value of an int
* variable defined in the derived class. At the point of definition of this
* variable, give it a nonzero value. In the base-class constructor, call this
* method. In main(), create an object of the drived type, and then call its
* print() method. Explain the results.
*/
/**
 * Created by wangcheng on 2017/4/20.
 */
abstract class Pri{
    abstract protected void print();
    Pri(){
        print();
    }
}

class Dao extends Pri{
    private int i = 4;
    protected void print(){System.out.println("i = " + i);}
}
public class Ex3 {
    public static void main(String[] args){
        Dao d  =new Dao();
        d.print();
    }
}
