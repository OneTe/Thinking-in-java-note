package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 14, page361
/* Modify interfaces/HorrorShow.java to implement DangerousMonster and
* Vampire using anonymous classes.
*/
/**
 * Created by wangcheng on 2017/6/19.
 */
interface Monster{void menace();}
interface Lethal{void kill();}
interface DangerousMonster extends Monster{void destroy();}
interface Vampire extends DangerousMonster,Lethal{void drinkBlood();}
class Anonymous{
    public DangerousMonster dragonZilla(){
        return new DangerousMonster() {
            public void destroy(){System.out.println("DangerousMonster Destroy");}
            public void menace(){System.out.println("DangerousMonster Menace");}
        };
    }
    public Vampire veryBadVampire(){
        return new Vampire() {
            @Override
            public void drinkBlood() {System.out.println("Vampire drinkBlood");}
            @Override
            public void destroy() {System.out.println("Vampire destroy");}
            @Override
            public void kill() {System.out.println("Vampire kill");}
            @Override
            public void menace() {System.out.println("Vampire menace");}
        };
    }
}
public class HorrorShow14 {
    static void u(Monster b){b.menace();}
    static void v(DangerousMonster d){
        d.menace();
        d.destroy();
    }
    static void w(Lethal l){l.kill();}
    public static void main(String[] args){
        DangerousMonster barney = new Anonymous().dragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new Anonymous().veryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}


//interface Monster{
//    void menace();
//}
//interface DangerousMonster extends Monster{
//    void destroy();
//}
//interface Lethal{
//    void kill();
//}
//class DragonZilla implements DangerousMonster{
//    public void menace(){}
//    public void destroy(){}
//}
//interface Vampire extends DangerousMonster,Lethal{
//    void drinkBlood();
//}
//class VeryBadVampire implements Vampire{
//    public void menace(){}
//    public void destroy(){}
//    public void kill(){}
//    public void drinkBlood(){}
//}
//public class HorrorShow {
//    static void u(Monster b){b.menace();}
//    static void v(DangerousMonster d){
//        d.menace();
//        d.destroy();
//    }
//    static void w(Lethal l){l.kill();}
//    public static void main(String[] args){
//        DangerousMonster barney = new DragonZilla();
//        u(barney);
//        v(barney);
//        Vampire vlad = new VeryBadVampire();
//        u(vlad);
//        v(vlad);
//        w(vlad);
//    }
//}