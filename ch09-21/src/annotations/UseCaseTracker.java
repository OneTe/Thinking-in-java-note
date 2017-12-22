package annotations;

// 使用反射机制查询@UseCase标记
import java.lang.reflect.*;
import java.util.*;
/**
 * Created by wangcheng  on 2017/12/22.
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> cl){
        for(Method m : cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found use case:" + uc.id() +
                " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for(int i : useCases){
            System.out.println("Warning: Missing use case-" + i);
        }
    }
    public static void main(String[] args){
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);
        trackUseCases(useCases,PasswordUtils.class);
    }
}
