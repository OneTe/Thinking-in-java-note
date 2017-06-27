package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 19, page 366
/* Create a class containing an inner class that itself contains an inner
* class. Repeat this using nested classes. Note the names of the .class files
* produced by the compiler.
*/
/**
 * Created by wangcheng on 2017/6/23.
 */
public class Ex19 {
    Ex19(){System.out.println("Ex19()");}
    private class Ex19Inner{
        Ex19Inner(){System.out.println("Ex19Inner()");}
        private class Ex19InnerInner{
            Ex19InnerInner(){System.out.println("Ex19InnerInner()");}
        }
    }
    private static class Ex19Nested{
        Ex19Nested(){System.out.println("EX19Nested()");}
        private static class Ex19NestedNested{
            Ex19NestedNested(){System.out.println("Ex19NestedNested()");}
        }
    }
    public static void main(String[] args){
        Ex19Nested en = new Ex19Nested();
        Ex19Nested.Ex19NestedNested een = new Ex19Nested.Ex19NestedNested();
        Ex19 e19 = new Ex19();
        Ex19.Ex19Inner ex = e19.new Ex19Inner();
    }

}
