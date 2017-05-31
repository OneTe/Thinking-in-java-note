package innerclasses;

/**
 * Created by wangcheng on 2017/5/31.
 */
public class Ex6Base {
    protected class Ex6BaseInner implements Ex6Interface{
        public Ex6BaseInner(){}
        public String say(){return "Hi";}
    }
}
