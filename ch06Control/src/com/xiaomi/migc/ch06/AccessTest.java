package com.xiaomi.migc.ch06;

/**
 * Created by wangcheng on 2017/3/9.
 */
public class AccessTest {
    public static void main(String[] args){
        FourWays fw = new FourWays();
        fw.showa();
        fw.showb();
        fw.showc();
        fw.a = 10;
        fw.b = 20;
        fw.c = 30;
        fw.showa();
        fw.showb();
        fw.showc();
        //fw.showd(); private access ,forbid
    }
}
