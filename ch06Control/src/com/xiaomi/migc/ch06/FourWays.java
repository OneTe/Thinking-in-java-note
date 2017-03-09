package com.xiaomi.migc.ch06;

/**
 * Created by wangcheng on 2017/3/9.
 */
public class FourWays {
    int a = 0;
    public int b = 1;
    protected int c = 2;
    private int d = 3;
    FourWays(){
        System.out.println("FourWays() Constructor");
    }
    void showa(){
        System.out.println(a);
        new FourWays();
    }
    public void showb(){
        System.out.println(b);
    }
    protected void showc(){
        System.out.println(c);
    }
    private void showd(){
        System.out.println(d);
    }

}
