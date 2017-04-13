package polymorphism.music8;
import polymorphism.music.Note;
// TIJ4 Chapter Polymorphism, Exercise 8, page 289
/* Modify Music3.java so that it randomly creates Instrument objects the way
* Shapes.java does.
*/

/**
 * Created by wangcheng on 2017/4/13.
 */
class Instrument{
    void play(Note n){
        System.out.println("Instrument.play() " + n);
    }
    String what(){
        return "Instrument";
    }
    void adjust(){
        System.out.println("Adjusting Instrument");
    }
}
class Wind extends Instrument{
    void play(Note n){
        System.out.println("Wind.paly() " + n);
    }
    String what(){
        return "Wind";
    }
    void adjust(){
        System.out.println("Adjusting Wind");
    }
}
class Percussion extends Instrument{
    void play(Note n){
        System.out.println("Percussion.play() " + n);
    }
    String what(){
        return "Percussion";
    }
    void adjust(){
        System.out.println("Adjusting Percussion");
    }
}
class Stringed extends Instrument{
    void play(Note n){
        System.out.println("Stringed.play() " + n);
    }
    String what(){
        return "Stringed";
    }
    void adjust(){
        System.out.println("Adjusting Stringed");
    }
}
class Keyboard extends Instrument{
    void play(Note n){ System.out.println("Keyboard.play() " + n);}
}
class Brass extends Wind{
    void play(Note n){
        System.out.println("Brass.play() " + n);
    }
    void adjust(){
        System.out.println("Adjusting Brass");
    }
}
class Woodwind extends Wind{
    void play(Note n){
        System.out.println("Woodwind.play() " + n);
    }
    String what(){
        return "Woodwind";
    }
}
class Piano extends Keyboard{
    void play(Note n){ System.out.println("Piano.play()" + n); }
}
public class Music8 {
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e){
        for(Instrument i :e){
            tune(i);
        }
    }
    private static RandomInstrumentGenerator x = new RandomInstrumentGenerator();
    public static void main(String[] args){
        Instrument[] s = new Instrument[7];
        for(int i =0;i<s.length;i++){
            s[i] = x.next();
        }
        for(Instrument i :s){
            tune(i);
        }
        //upcasting during addition to the array:
//        Instrument[] orchestra={
//                new Wind(),
//                new Percussion(),
//                new Stringed(),
//                new Brass(),
//                new Woodwind()
//        };
//        tuneAll(orchestra);
    }
}
