package generics.storyCharacters;

/**
 * Created by wangcheng  on 2017/9/18.
 */
import net.mindview.util.*;
import java.util.*;
public class StoryCharacterGenerator implements Generator<StoryCharacter>,Iterable<StoryCharacter>{
    private Class[] types = {DarthVader.class,JabbaTheHut.class,LukeSkywalker.class,Yoda.class};
    private static Random rand = new Random(47);
    public StoryCharacterGenerator(){}
    private int size = 0;
    public StoryCharacterGenerator(int sz){size = sz;}

    @Override
    public StoryCharacter next() {
        try {
            return (StoryCharacter) types[rand.nextInt(types.length)].newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<StoryCharacter> iterator() {
        return new Iterator<StoryCharacter>() {
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public StoryCharacter next() {
                size--;
                return StoryCharacterGenerator.this.next();
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args){
        StoryCharacterGenerator sc = new StoryCharacterGenerator(10);
        for(StoryCharacter s : sc){
            System.out.print(s + " ");
        }
    }
}
