package net.mindview.util;
// A Collection filled with data using a generator object.
/**
 * Created by wangcheng  on 2017/10/17.
 */
import java.util.*;
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for(int i = 0; i < quantity; i++)
            add(gen.next());
    }
    // A generic convenience method:
    public static <T> CollectionData<T>
    list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}
