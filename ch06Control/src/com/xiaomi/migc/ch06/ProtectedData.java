package com.xiaomi.migc.ch06;

/**
 * Created by wangcheng on 2017/3/9.
 */
class SomeData{
    protected  int a = 1;
}
class ChangeData{
    static void change(SomeData sd,int i){
        sd.a=i;
    }
}
public class ProtectedData {
    public static void main(String[] args){
        SomeData sd = new SomeData();
        System.out.println(sd.a);
        ChangeData.change(sd,20);
        System.out.println(sd.a);
    }
}
