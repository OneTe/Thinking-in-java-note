package exceptions;
//Catching exception hierarchies
/**
 * Created by wangcheng on 2017/8/25.
 */
class Annoyance extends Exception{}
class Sneeze extends Annoyance{}
public class Human {
    public static void main(String[] args){
        //Catch the exact type:
        try {
            throw new Sneeze();
        }catch (Sneeze e){
            System.out.println("Caught Sneeze");
        }catch (Annoyance a){
            System.out.println("Caught Annyance");
        }
        try {
            throw new Sneeze();
        }catch (Annoyance a){
            System.out.println("Caught Annoyance");
        }
    }
}
