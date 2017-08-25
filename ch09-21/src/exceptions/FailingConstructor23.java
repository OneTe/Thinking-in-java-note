package exceptions;
// TIJ4 Chapter Exceptions, Exercise 23, page 489
/* Add a class with a dispose() method to the previous exercise. Modify
* FailingConstructor so that the constructor creates one of these disposable
* objects, after which the constructor might through an exception, after which
* it creates a second disposable member object. Write code to properly guard
* against failure, and in main() verify that all possible failure situations
* are covered.
*/

import Interfaces.test.Interface;

/**
 * Created by wangcheng on 2017/8/25.
 */
class Disposable{
    private static int counter = 0;
    private int id = counter++;
    private boolean disposed;
    Disposable(){
        disposed = false;
    }
    void dispose(){
        disposed = true;
    }
    String checkStatus(){
        return (id + " " + (disposed ? "disposed" : "not disposed"));
    }
}
public class FailingConstructor23 {
    private Integer[] ia = new Integer[2];
    private static Disposable d0;
    private static Disposable d1;

    FailingConstructor23() throws Exception {
        try {
            d0 = new Disposable();
            try {
                ia[2] = 2;
                try {
                    d1 = new Disposable();
                } catch (Exception e) {
                    System.out.println("Caught e in inner try loop");
                    e.printStackTrace(System.err);
                    System.out.println("Failed to create d1");
                }
            } catch (Exception e) {
                System.out.println("Caught e in middle try loop");
                e.printStackTrace(System.err);
                System.out.println("Disposing d0");
                d0.dispose();
            }
        } catch (Exception e) {
            System.out.println("Caught in outer try loop");
            e.printStackTrace(System.err);
            System.out.println("Failed to create d0");
        }
    }
    public static void main(String[] args){
        try {
            FailingConstructor23 fc = new FailingConstructor23();
        }catch (Exception e){
            System.out.println("Caught Exception in main()");
            e.printStackTrace(System.err);
        }
    }
}