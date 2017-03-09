package com.xiaomi.migc.ch06;

/**
 * Created by wangcheng on 2017/3/9.
 */
class Soup1{
    private Soup1(){}
    public static Soup1 makeSoup(){
        return new Soup1();//返回一个对Soup 类的对象的引用
    }
}

class Soup2{ //单例模式
    private Soup2(){}
    private static Soup2 ps1 = new Soup2();
    public static Soup2 access(){
            return ps1;
    }
    public void f(){}
}

public class Lunch {
    void testPrivate(){
        //can't do this ,private
       // Soup1 soup = new Soup1();
    }
    void testStatic(){
        Soup1 soup = Soup1.makeSoup();
    }
    void testSingleton(){
        Soup2.access().f();
    }
}
