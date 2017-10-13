package generics;
//Using Reflection to produce latent typing.
//这个相当于动态语言如python的直接调某个类的方法，如果该类没有这个方法，则在运行时会抛出异常。只是java没这种机制，可以通过反射来实现
//只是这个缺点是把所有类型检查都转移到运行时了
/* python
class Dog:
    def speak(self):
        print "Arf!"
    def sit(self):
        print "sitting"
class Robot:
    def speak(self)
        print "click!"
    def sit(self)
        print "Clank!"
def perform(anything):
    anything.speak()
    anything.sit()
*/
/**
 * Created by wangcheng  on 2017/10/13.
 */

import java.lang.reflect.*;

class Mime{
    public void walkAgainstTheWind(){}
    public void sit(){System.out.println("Pretending to sit");}
    public void pushInvisibleWalls(){}
    public String toString(){return "Mime";}
}
class SmartDog{
    public void speak(){System.out.println("Woof!");}
    public void sit(){System.out.println("Sitting");}
    public void reproduce(){}
}
class CommunicateReflectively{
    public static void perform(Object speaker){
        Class<?> spkr = speaker.getClass();
        try{
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            }catch (NoSuchMethodException e){
                System.out.println(speaker + " cannot speak");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            }catch (NoSuchMethodException e){
                System.out.println(speaker + " cannot sit");
            }
        }catch (Exception e){
            throw new RuntimeException(speaker.toString(),e);
        }
    }
}
public class LatentReflection {
    public static void main(String[] args){
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Mime());
    }
}
