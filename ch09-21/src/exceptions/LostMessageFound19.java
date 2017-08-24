package exceptions;
// TIJ4 Chapter Exceptions, Exercise 19, page 479
// Repair the problem in LostMessage.java by guarding the call in the
// finally clause.
/**
 * Created by wangcheng on 2017/8/23.
 */
public class LostMessageFound19 {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    public static void main(String[] args) {
        try {
            LostMessageFound19 lmf = new LostMessageFound19();
            try {
                lmf.f();
            } catch(Exception e) {
                System.out.println(e);
            } finally {
                lmf.dispose();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
