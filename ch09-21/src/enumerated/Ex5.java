package enumerated;

import net.mindview.util.Enums;

import java.util.*;
/****************** Exercise 5 *****************
 * Modify control/VowelsAndConsonants.java so that
 * it uses three enum types: VOWEL, SOMETIMES_A_VOWEL,
 * and CONSONANT. The enum constructor should take
 * the various letters that describe that particular
 * category. Hint: Use varargs, and remember that
 * varargs automatically creates an array for you.
 ***********************************************/
/**
 * Created by wangcheng  on 2017/12/15.
 */
enum CharacterCategory{
    VOWEL('a','e','i','o','u'){
        public String toString(){ return "vowel";}
    },
    SOMETIMES_A_VOWEL('y','w'){
        public String toString(){return "Sometimes a vowel";}
    },
    CONSONANT{
        public String toString(){return "consonant";}
    };
    private HashSet<Character> chars = new HashSet<>();

    private CharacterCategory(Character ...chars) {
        if(chars != null)
            this.chars.addAll(Arrays.asList(chars));
    }
    public static CharacterCategory getCategory(Character c){
        if(VOWEL.chars.contains(c))
            return VOWEL;
        if(SOMETIMES_A_VOWEL.chars.contains(c))
            return SOMETIMES_A_VOWEL;
        return CONSONANT;
    }
}

public class Ex5 {
    public static void main(String[] args){
        Random rand = new Random(47);
        for(int i = 0;i<100;i++){
            int c = rand.nextInt(26) + 'a';
            System.out.print(" " + (char)c + ", " + c + ": ");
            System.out.print(CharacterCategory.getCategory((char)c).toString());
        }
    }
}


//public class VowelsAndConsonants {
//    public static void main(String[] args) {
//        Random rand = new Random(47);
//        for(int i = 0; i < 100; i++) {
//            int c = rand.nextInt(26) + 'a';
//            printnb((char)c + ", " + c + ": ");
//            switch(c) {
//                case 'a':
//                case 'e':
//                case 'i':
//                case 'o':
//                case 'u': print("vowel");
//                    break;
//                case 'y':
//                case 'w': print("Sometimes a vowel");
//                    break;
//                default:  print("consonant");
//            }
//        }
//    }
//}