package innerclasses;
//可以使用嵌套类来放置测试代码
/**
 * Created by wangcheng on 2017/6/29.
 */
public class TestBed {
    public void f(){System.out.println("f()");}
    public static class Tester{
        public static void main(String[] args){
            TestBed t = new TestBed();
            t.f();
        }
    }
}
