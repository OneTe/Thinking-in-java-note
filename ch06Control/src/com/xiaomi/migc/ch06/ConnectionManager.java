package com.xiaomi.migc.ch06;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * Created by wangcheng on 2017/3/9.
 */
class Connection{
    private static int count = 0;
    private int i = 0;
    private Connection(){System.out.println("Connection");}
    static Connection makeConnection(){
        count++;
        return new Connection();
    }
    public static int howMany(){return count;};
    public String toString(){
        return ("Connection : "+count);
    }
}

public class ConnectionManager {
    static int howManyLeft = 3;
    static Connection[] ca = new Connection[3];
    //构造代码块：http://blog.csdn.net/chenssy/article/details/14486833
    {
        for (Connection x : ca)
        x = Connection.makeConnection();
   }
    public static Connection getConnection(){
        if(howManyLeft > 0){
            return ca[--howManyLeft];
        }else {
            System.out.println("No more Connection");
            return null;
        }
    }
    public static void main(String[] args){
        //System.out.println(ConnectionManager.howManyLeft);
        ConnectionManager cm = new ConnectionManager();
        System.out.println(cm.howManyLeft);
        cm.getConnection();
        System.out.println(howManyLeft);
        cm.getConnection();
        System.out.println(howManyLeft);
        cm.getConnection();
        System.out.println(cm.getConnection());
        System.out.println(howManyLeft);
    }


}
