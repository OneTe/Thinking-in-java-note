package annotations.database;
//Sample of nested annotations
/**
 * Created by wangcheng  on 2017/12/22.
 */
public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
