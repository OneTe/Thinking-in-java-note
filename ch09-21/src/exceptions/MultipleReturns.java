package exceptions;

/**
 * Created by wangcheng on 2017/8/23.
 */
public class MultipleReturns {
    public static void f(int i){
        System.out.println("Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            if(i == 1) return;
            System.out.println("Point 2");
            if(i ==2 ) return;
            System.out.println("Point 3");
            if(i == 3) return;
            System.out.println("End");
            return;
        }finally {
            System.out.println("Performing cleanup");
        }
    }
    public static void main(String[] args){
        for(int j = 1;j<=4;j++){
            f(j);
        }
    }
}
