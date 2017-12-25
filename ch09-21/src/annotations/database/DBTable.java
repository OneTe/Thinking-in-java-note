package annotations.database;

/**
 * Created by wangcheng  on 2017/12/22.
 */
import java.lang.annotation.*;

@Target(ElementType.TYPE)//Applies to classes only
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}
