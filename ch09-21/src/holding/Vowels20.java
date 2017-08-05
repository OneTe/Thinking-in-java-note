package holding;
// TIJ4 Chapter Holding, Exercise 20, page 422
// Modify Exercise 16 so that you keep a count of the occurence of each vowel.
/**
 * Created by wangcheng on 2017/8/4.
 */
import java.util.*;
public class Vowels20 {
    static void vowelCounter20(Set<String> st){
        Set<Character> vowel = new TreeSet<>();
        Collections.addAll(vowel,
                'A','E','I','O','U','a','e','i','o','u');
        int allVoewls = 0;
        Map<Character,Integer> vowelMap = new TreeMap<>();
        for(String s :st){
            for(Character v : s.toCharArray()){
                if(vowel.contains(v)){
                    Integer count = vowelMap.get(v);
                    vowelMap.put(v,
                            count==null?1:count+1);
                    allVoewls++;
                }
            }
        }
        System.out.println("Vowels: " + vowelMap);
        System.out.println("Total vowels: " + allVoewls);
    }
    public static void main(String[] args){
        Set<String> words = new TreeSet<>(new TextFile("src/holding/SetOperations.java","\\W+"));
        System.out.println(words);
        System.out.println();
        vowelCounter20(words);
    }
}
