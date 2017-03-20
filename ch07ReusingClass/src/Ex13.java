/**
 * Created by wangcheng on 2017/3/20.
 */
class Animal{
    String yelp(String s){
        System.out.println("haha");
        return "aa";
    }
    char yelp(char c){
        System.out.println('h');
        return 'g';
    }
    int yelp(int i){
        System.out.println(1);
        return 1;
    }
}
class Yan{}
class Bird extends Animal{
    void yelp(Yan y){
        System.out.println("Bird(Yan)");
    }
}
public class Ex13 {
    public static void main(String[] args){
        Bird b = new Bird();
        b.yelp("aa");
        b.yelp('c');
        b.yelp(1);
        b.yelp(new Yan());
    }
}
