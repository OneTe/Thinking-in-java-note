package innerclasses;

/**
 * Created by wangcheng on 2017/5/25.
 */
public class TestSort {
    public static void main(String[] args){
        int[] s= {12,34,2,291,29,240,10};
        int temp;
        for(int i=0;i<s.length-1;i++){
            for(int j=0;j<s.length-i-1;j++){
                if(s[j]>s[j+1]) {
                    temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]+ " ");
        }
    }
}
