package polymorphism.music7;
import polymorphism.music.Note;
// TIJ4 Chapter Polymorphism, Exercise 7, page 289
/* Add a new Instrument to Music3.java and verify that polymorphism works for
* your new type.
*
/**
 * Created by wangcheng on 2017/4/13.
 */
class Instrument {
    void play(Note n) { System.out.println("Instrument.play() " + n); }
    public String toString() { return "Instrument"; }
    void adjust() { System.out.println("Adjusting Instrument"); }
}
class Wind extends Instrument{
    void play(Note n) { System.out.println("Wind.play() " + n); }
    public String toString(){ return "Wind"; }
    void adjust() { System.out.println("Adjusting Wind");}
}
class Percussion extends Instrument{
    void play(Note n) { System.out.println("Percussion.play() " + n);}
    public String toString(){ return "Percussion"; }
    void adjust() { System.out.println("Adjusting Percussion"); }
}
class Stringed extends Instrument{
    void play(Note n) { System.out.println("Stringed.play() " + n );}
    public String toString(){return "Stringed"; }
    void adjust(){ System.out.println("Adjusting Stringed ");}
}
class Keyboard extends Instrument{
    void play(Note n){ System.out.println("Keyboard.play()" + n);}
    public String toString(){ return "Keyboard"; }
    void adjust(){ System.out.println("Adjusting Keyboard");}
}
class Brass extends Wind{
    void play(Note n){ System.out.println("Brass.play()" + n);}
    public String toString(){ return "Brass"; }
    void adjust(){ System.out.println("Adjusting Brass");}
}
class Woodwind extends Wind{
    void play(Note n){ System.out.println("Woodwind.play() " + n);}
    public String toString(){ return "Woodwind"; }
    void adjust(){ System.out.println("Adjusting Woodwind");}
}
class Piano extends Keyboard{
    void play(Note n){ System.out.println("Piano.play() " + n);}
    public String toString(){ return "Piano"; }
    void adjust(){ System.out.println("Adjusting Piano"); }
}
public class Music7 {
    public static void tune(Instrument i ){
        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e){
        for(Instrument i : e){
            tune(i);
        }
    }
    public static void main(String[] args){
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind(),
                new Piano()
        };
        tuneAll(orchestra);
        for(Instrument i : orchestra){
            System.out.println(i);
        }
    }
}
