package Interfaces.music10;

import Interfaces.music4.Note;
// TIJ4 Chapter Interfaces, Exercise 10, page 320
/* Modify Music5.java by adding a Playable interface. Move the play() declaration
* from Instrument to Playable. Add Playable to the derived classes by including
* it in the implements list. Change tune() so that it takes a Playable instead
* of and Instrument.
*/
/**
 * Created by wangcheng on 2017/4/23.
 */
interface Instrument{
    int VALUE = 5;
    void adjust();
}
interface Playable{
    void play(Note n);
}
class Wind implements Instrument,Playable{
    public void play(Note n){System.out.println(this + ".play() " + n);}
    public String toString(){return "Wind";}
    public void adjust(){System.out.println(this + "adjust()");}
}
class Percussion implements Instrument,Playable{
    public void play(Note n){System.out.println(this + ".play() " + n);}
    public String toString(){return "Percussion";}
    public void adjust(){System.out.println(this + ".adjust()");}
}
class Stringed implements Instrument,Playable{
    public void play(Note n){System.out.println(this + ".play() " + n);}
    public String toString(){return  "Stringed";}
    public void adjust(){System.out.println(this + ".adjust()");}
}
class Brass extends Wind{
    public String toString(){return "Brass()";}
}
class Woodwind extends  Wind{
    public String toString(){return "Woodwind()";}
}
public class Music10 {
    static void tune(Playable p){
        p.play(Note.MIDDLE_C);
    }
    static void tuneAll(Playable[] pl){
        for(Playable p : pl){
            tune(p);
        }
    }
    public static void main(String[] args){
        Playable[] pl = {new Wind(),new Percussion(),new Stringed(),new Brass(),new Woodwind()};
        tuneAll(pl);
    }
}
