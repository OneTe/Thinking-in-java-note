package exceptions;
// TIJ4 Chapter Exceptions, Exercise 18, page 479
// Add a second level of exception loss to LostMessage.java so that the
// HoHumException is itself replaced by a third exception.
/**
 * Created by wangcheng on 2017/8/23.
 */
class MeaninglessException extends Exception {
    public String toString() {
        return "A meaningless exception";
    }
}
public class LostMessage18a {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    void eliminate() throws MeaninglessException {
        throw new MeaninglessException();
    }
    public static void main(String[] args){
        try{
            LostMessage18a lm = new LostMessage18a();
            try{
                try {
                    lm.f();
                    lm.dispose();
                }finally {
                    lm.eliminate();
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
