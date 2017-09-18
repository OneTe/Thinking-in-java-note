package generics.storyCharacters;

/**
 * Created by wangcheng  on 2017/9/18.
 */
public class StoryCharacter {
    private static long counter = 0;
    private final long id = counter++;
    public String toString(){
        return getClass().getSimpleName() + " " + id;
    }
}
