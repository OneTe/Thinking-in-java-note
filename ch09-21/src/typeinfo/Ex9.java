package typeinfo;

/**
 * Created by wangcheng  on 2017/9/1.
 */
class A9{ int i;String s;}
class B9 extends A9{int j; float f;}
class C9 extends B9{int k;B9 b;}
public class Ex9 {
    public static void Hierarchy(Object o){
        Object[] fields = o.getClass().getDeclaredFields();
        if(fields.length <1){
            System.out.println("have no fields");
        }
        if(fields.length >1){
            System.out.println(o.getClass() + "has fields :");
            for(Object o1 : fields){
                System.out.println( " " + o1);
            }
        }
        if(o.getClass().getSuperclass() !=null){
            //same as Ex8a
        }
    }
    public static void main(String[] args){
        Hierarchy(new C9());
    }
}
