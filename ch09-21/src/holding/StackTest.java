package holding;

/**
 * Created by wangcheng on 2017/8/3.
 */
public class StackTest {
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        for(String s : "My dog has fleas".split(" ")){
            stack.push(s);
        }
        while (!stack.empty()){
            System.out.println(stack.pop() + " ");
        }
    }
}
