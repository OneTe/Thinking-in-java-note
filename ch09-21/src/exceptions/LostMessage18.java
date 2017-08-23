package exceptions;

/**
 * Created by wangcheng on 2017/8/23.
 */
class ThreeException18 extends Exception{
    public String toString(){
        return "Three Exception!";
    }
}
public class LostMessage18 {
    void f() throws VeryImportantException{
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException{
        throw new HoHumException();
    }
    void g() throws ThreeException18{
        throw new ThreeException18();
    }
    public static void main(String[] args) {
        try {
            LostMessage18 lm = new LostMessage18();
            try {
                try {
                    lm.f();
                } finally {
                    lm.dispose();
                }
            } finally {
                lm.g();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
