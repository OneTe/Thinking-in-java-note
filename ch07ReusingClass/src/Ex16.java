/**
 * Created by wangcheng on 2017/3/22.
 * EX16
 * 到底是选择使用组合还是继承，一个办法是看是否需要从新类向基类进行向上转型。如果必须向上转型，则继承是必须的。
 * 如果不需要，得好好考虑是不是需要继承
 */
class Amphibian {
    protected void swim() {
        System.out.println("Amphibian swim");
    }
    protected void speak() {
        System.out.println("Amphibian speak");
    }
    void eat() {
        System.out.println("Amphibian eat");
    }
    static void grow(Amphibian a) {
        System.out.println("Amphibian grow");
        a.eat();
    }
}

public class Ex16 extends Amphibian {
  //  void eat(){System.out.println("Ex16 eat");}
    public static void main(String[] args) {
        Ex16 f = new Ex16();
        // call base-class methods:
        f.swim();
        f.speak();
        f.eat();
        // upcast Ex17 to Amphibian argument:
        Amphibian.grow(f);
    }
}
