package exceptions;

/**
 * Created by wangcheng on 2017/8/25.
 */
class AException extends Exception{
    void euq(){
        throw new RuntimeException("in A");
    }
}
class BException extends AException{
    void euq(){
        throw new RuntimeException("in B");
    }
}
class CException extends BException{
    void euq(){
        throw new RuntimeException("in C");
    }
}
public class Ex25 {
    public static void main(String[] args){
        AException ce = new CException();
        ce.euq();
    }
}
