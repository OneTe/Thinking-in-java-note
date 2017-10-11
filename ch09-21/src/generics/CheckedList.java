package generics;
//Using Collection.checkedList()
/**
 * Created by wangcheng  on 2017/10/11.
 */
import typeinfo.pets.*;
import java.util.*;

public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs){
        probablyDogs.add(new Cat());
    }
    public static void main(String[] args){
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1);//Quietly accepts a Cat
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(),Dog.class);
        try{
            oldStyleMethod(dogs2);
        }catch (Exception e){
            System.out.println(e);
        }
        //Derived types work fine:
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(),Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
