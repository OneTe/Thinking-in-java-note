package typeinfo;
//Using a dynamic proxy to create a Null Object.
/**
 * Created by wangcheng  on 2017/9/13.
 */
import java.util.*;
import java.lang.reflect.*;
import net.mindview.util.*;

class NullRobotProxyHandler implements InvocationHandler{
    private String nullName;
    private Robot proxied = new NRobot();
    NullRobotProxyHandler(Class<? extends Robot> type){
        nullName = type.getSimpleName() + " NullRobot";
    }
    private class NRobot implements Null,Robot{
        public String name(){return nullName;}
        public String model(){return nullName;}
        public List<Operation> operations(){
            return Collections.emptyList();
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied,args);
    }
}
//如果你需要一个空Robot对象，只需调用newNullRobot(),并传递需要代理的Robot类型
public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type){
        return (Robot)Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{Null.class,Robot.class},
                new NullRobotProxyHandler(type)
        );
    }
    public static void main(String[] args){
        Robot[] bots = {
                new SnowRemovalRobot("SnowBee"),
                newNullRobot(SnowRemovalRobot.class)
        };
        for(Robot bot : bots){
            Test.test(bot);
        }
    }
}
