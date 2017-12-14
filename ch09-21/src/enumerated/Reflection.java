package enumerated;
//Analyzing enums using reflection.
//Enum don't have the values() method.

import net.mindview.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wangcheng  on 2017/12/13.
 */
enum Explore{HERE,THERE}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("------ Analyzing " + enumClass + " -------");
        System.out.println("Interfaces:");
        for(Type t : enumClass.getGenericInterfaces())
            System.out.println(t);
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.print("Methods: ");
        Set<String> methods = new TreeSet<>();
        for(Method m : enumClass.getMethods())
            methods.add(m.getName());
        System.out.print(methods);
        System.out.println();
        return methods;
    }
    public static void main(String[] args){
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods =analyze(Enum.class);
        System.out.println("Explore.containAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        System.out.println("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
        //OSExecute.command("javap Explore");
    }
}
//OSExecute.command("javap Explore");结果如下：
//    Compiled from "Reflection.java"
//final class enumerated.Explore extends java.lang.Enum<enumerated.Explore> {
//public static final enumerated.Explore HERE;
//public static final enumerated.Explore THERE;
//public static enumerated.Explore[] values();
//public static enumerated.Explore valueOf(java.lang.String);
//static {};
//        }