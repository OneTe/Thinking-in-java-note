/**
 * Created by wangcheng on 2017/3/14.
 * Ex7
 */
class A2 {
    A2(char c, int i) { System.out.println("A(char, int)");}
}

class B2 extends A2 {
    B2(String s, float f){
        super(' ', 0);
        System.out.println("B(String, float)");
    }
}

class Ex7 extends A2 {
    private char c;
    private int i;
    Ex7(char a, int j) {
        super(a, j);
        c = a;
        i = j;
    }
    B2 b = new B2("hi", 1f); // will then construct another A and then a B
    public static void main(String[] args) {
        Ex7 c = new Ex7('b', 2); // will construct an A first
    }
}
