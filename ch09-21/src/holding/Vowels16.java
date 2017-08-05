package holding;
// TIJ4 Chapter Holding, Exercise 16, page 419
/* Create a Set of the vowels. Working from UniqueWords.java, count and
* display the number of vowels in each input word, and also display the total
* number of vowels in the input file.
*/
/**
 * Created by wangcheng on 2017/8/4.
 */
import java.util.*;
public class Vowels16 {
    static void vowelCounter(Set<String> st){
        Set<Character> vowels = new TreeSet<>();
        Collections.addAll(vowels,
                'A','E','I','O','U','a','e','i','o','u');
        int allVowels = 0;
        for(String s: st){
            int count = 0;
            for(Character v : s.toCharArray()){
                if(vowels.contains(v)){
                    count++;
                    allVowels++;
                }
            }
            System.out.print(s + ": " + count + ", ");
        }
        System.out.println();
        System.out.print("Total vowels: " + allVowels);
    }
    public static void main(String[] args){
        Set<String> words = new TreeSet<>(new TextFile("src/holding/SetOperations.java","\\W+"));
        System.out.println(words);
        System.out.println();
        vowelCounter(words);
    }
}
