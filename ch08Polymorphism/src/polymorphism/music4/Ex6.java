package polymorphism.music4;
import polymorphism.music.Note;
// TIJ4 Chapter Polymorphism, Exercise 6, page 289
/* Change Music3.java so that what() beccomes the root Object method toString().
* Try printing the Instrument objects using System.out.println() without any
* casting.
*/
/**
 * Created by wangcheng on 2017/4/13.
 */
class Instrument{
    void play(Note n){
        System.out.println("Instrument.play() " + n);
    }
    public String toString(){
        return "Instrument";
    }
    void adjust(){
        System.out.println("Adjusting Instrument");
    }
}
class Wind extends Instrument {
    void play(Note n){
        System.out.println("Wind.paly() " + n);
    }
    public String toString(){
        return "Wind";
    }
    void adjust(){
        System.out.println("Adjusting Wind");
    }
}
class Percussion extends Instrument {
    void play(Note n){
        System.out.println("Percussion.play() " + n);
    }
    public String toString(){
        return "Percussion";
    }
    void adjust(){
        System.out.println("Adjusting Percussion");
    }
}
class Stringed extends Instrument {
    void play(Note n){
        System.out.println("Stringed.play() " + n);
    }
    public String toString(){
        return "Stringed";
    }
    void adjust(){
        System.out.println("Adjusting Stringed");
    }
}
class Brass extends Wind {
    void play(Note n){
        System.out.println("Brass.play() " + n);
    }
    public String toString(){
        return "Brass";
    }
    void adjust(){
        System.out.println("Adjusting Brass");
    }
}
class Woodwind extends Wind {
    void play(Note n){
        System.out.println("Woodwind.play() " + n);
    }
    public String toString(){
        return "Woodwind";
    }
}

public class Ex6 {
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e){
        for(Instrument i :e){
            tune(i);
        }
    }
    public static void main(String[] args){
        //upcasting during addition to the array:
        Instrument[] orchestra={
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
        for(Instrument i :orchestra){
            System.out.println(i);
        }
    }
}
