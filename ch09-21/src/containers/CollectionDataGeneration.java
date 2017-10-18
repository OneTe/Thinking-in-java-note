package containers;
//Using the Generators defined in the Arrays chapter.
/**
 * Created by wangcheng  on 2017/10/17.
 */
import java.util.*;
import net.mindview.util.*;

public class CollectionDataGeneration {
    public static void main(String[] args){
        System.out.println(new ArrayList<String>(CollectionData.list(
                new RandomGenerator.String(9),10
        )));
        System.out.println(new HashSet<Integer>(new CollectionData<Integer>(new RandomGenerator.Integer(),10)));
        //System.out.println(new ArrayList<>(Arrays.asList(1,2,3,4)));
    }
}
