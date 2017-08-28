package exceptions;
// TIJ4 Chapter Exceptions, Exercise 30, page 500
/* Modify Human.java so that the exceptions inherit from
* RuntimeException. Modify main() so that the technique
* in TurnOffChecking.java is used to handle the different
* types of exceptions.
*/
/**
 * Created by wangcheng  on 2017/8/28.
 */
class Annoyance30 extends RuntimeException{}
class Sneeze30 extends Annoyance30{}

class WrapCheckedExceptions{
    void throwRuntimeException(int type){
        try {
            switch(type){
                case 0:throw new Annoyance30();
                case 1:throw new Sneeze30();
                case 2:throw new RuntimeException("Where am I?");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
public class Human30 {
    public static void main(String[] args){
        WrapCheckedExceptions wce = new WrapCheckedExceptions();
        for(int i = 0;i<3;i++){
            try{
                if(i < 3){
                    wce.throwRuntimeException(i);
                }else {
                    throw new RuntimeException();
                }
            }catch (RuntimeException re){
                try {
                    throw re.getCause();
                }catch (Sneeze30 e){
                    System.out.println("Sneeze30: " + e);
                }catch (Annoyance30 e){
                    System.out.println("Annoyance30: " + e);
                }catch (Throwable e){
                    System.out.println("Throwable: " + e);
                }
            }
        }
    }
}
