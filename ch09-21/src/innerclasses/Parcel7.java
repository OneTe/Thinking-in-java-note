package innerclasses;
//创建一个继承自Contents的匿名类的对象。通过new表达式返回的引用被自动向上转型为对Contents的引用
/**
 * Created by wangcheng on 2017/6/7.
 */
public class Parcel7 {
    public Contents contents(){
        //匿名内部类
        return new Contents(){
            private int i = 11;
            public int value(){return  i;}
        };//Semicolon required in this case
    }
    public static void main(String[] args){
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}

//上述匿名内部类的语法是下述形式的简化：
//:innerclass/Parcel7b.java
// Expanded version of Parcel7.java
//public class Parcel7b{
//    class MyContents implements Contents{
//        private int i = 11;
//        public int value(){return  i;}
//    }
//    public Contents contents(){return new MyContents();}
//    public static void mian(String[] args){
//        Parcel7b p = new Parcel7b();
//        Contents c = p.contents();
//    }
//}