package exceptions;
//一个更加简单的丢失异常的方式是从finally子句中返回
/**
 * Created by wangcheng on 2017/8/23.
 */
public class ExceptionSilencer {
    public static void main(String[] args){
        try {
            throw new RuntimeException();
        }finally {
            //Using 'return' inside the finally block
            //will silence any thrown exception
            return;
        }
    }
}
