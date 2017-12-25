package annotations;
//使用组合的方式创建非嵌入式的测试

import net.mindview.atunit.Test;

/**
 * Created by wangcheng  on 2017/12/25.
 */
public class AtUnitComposition {
    AtUnitExample1 testObject = new AtUnitExample1();
    @Test boolean _methodOne(){
        return testObject.methodOne().equals("This is methodOne");
    }
    @Test boolean _methodTwo(){
        return testObject.methodTwo() == 2;
    }
    //...
}
