/**
 * Created by wangcheng on 2017/3/28.
 * fianl参数，可以读参数，缺无法修改参数
 * 这一个特性主要用来向匿名内部类传递数据
 */
class Gizmo{
    public void spin(){}
}
public class FinalArguments {
    void with(final Gizmo g){
       //! g=new Gizmo();//Illegl   --g is final
    }
    void without(Gizmo g){
        g= new Gizmo(); //OK --g is not final
        g.spin();
    }
   // void f(final int i){i++;} //can't change
    //you can only read from a final primitive:
    int g(final int i){return  i+1;}
    public static void main(String[] args){
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
}
