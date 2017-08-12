package typeinfo.pets;
//Facade to produce a default PetCreator
/**
 * Created by wangcheng on 2017/8/11.
 */
import java.util.*;
public class Pets {
    public static final PetCreator creator =
            new LiteralPetCreator();
    public static Pet randomPet() {
        return creator.randomPet();
    }
    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }
    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}
