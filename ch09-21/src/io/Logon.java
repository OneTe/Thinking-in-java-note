package io;
//Demonstrates the "transient" keyword
//transient关键字只能和Serializable对象一起使用
import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangcheng  on 2017/12/11.
 */
public class Logon implements Serializable{
    private Date date = new Date();
    private String username;
    private transient String password;
    public Logon(String name,String pwd){
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static void main(String[] args) throws Exception{
        Logon a = new Logon("Hulk","myLittlePony");
        System.out.println("Logon a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("src/io/logon.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1);//Delay
        //Now get them back
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/io/logon.out"));
        System.out.println("Recovering object at " + new Date());
        a = (Logon)in.readObject();
        System.out.println("Logon a = " + a);
    }
}
