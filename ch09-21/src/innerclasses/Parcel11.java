package innerclasses;
//嵌套类
//普通的内部类对象隐式地保存了一个引用，指向创建它的外围内对象。然而，当内部类是static时（通常称为嵌套类），就不是这样了
//1。要创建嵌套类的对象，并不需要其外围类的对象。 2。不能从嵌套类的对象中访问非静态的外围类对象。
//普通的内部类不能有static数据和static字段，也不能包含嵌套类。但是嵌套类可以包含这些东西。
/**
 * Created by wangcheng on 2017/6/23.
 */
//Nested classes (static inner classes)
public class Parcel11 {
    private static class ParcelContents implements Contents{
        private int i = 11;
        public int value(){return i;}
    }
    protected static class ParcelDestination implements Destination{
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
        }
        public String readLabel(){return label;}
        //Nested classes can contain other static elements;
        public static void f(){}
        static int x = 10;
        static class AnotherLevel{
            public static void f(){}
            static int x = 10;
        }
    }
    public static Destination destination(String s){
        return new ParcelDestination(s);
    }
    public static Contents contents(){
        return new ParcelContents();
    }
    public static void main(String[] args){
        Contents contents = contents();
        Destination d = destination("Tsmain");
    }
}
