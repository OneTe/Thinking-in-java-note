package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 13, page 361
/* Repeat Exercise 9 using an anonymous inner class.
* (Exercise 9: Create an interface with at least one method, and implement
* that interface by defining an inner class within a method, which returns
* a reference to your interface.)
*/
/**
 * Created by wangcheng on 2017/6/19.
 */
interface Ex13Interface{
    void say(String s);
}
public class Ex13 {
    public Ex13Interface re(){
        return new Ex13Interface() {
            @Override
            public void say(String s) {
               System.out.println(s);
            }
        };
    }
    public static void main(String[] args){
        Ex13 ex = new Ex13();
        ex.re().say("hha");
    }
}





//interface Ex9Interface{
//    void say(String s);
//}
//public class Ex9 {
//    public Ex9Interface re(){
//        class Inner implements Ex9Interface{
//            public  void say(String s){
//                System.out.println(s);
//            }
//        }
//        return  new Inner();
//    }
//    public static void main(String[] args){
//        Ex9 e = new Ex9();
//        e.re().say("haha!");
//    }
//}