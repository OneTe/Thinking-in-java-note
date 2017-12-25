package annotations;
//生成一个非嵌入式的测试，最简单的办法就是继承:

import net.mindview.atunit.Test;

/**
 * Created by wangcheng  on 2017/12/25.
 */
public class AtUnitExternalTest extends AtUnitExample1{
    @Test boolean _methodOne(){
        return methodOne().equals("This is methodOne");
    }
    @Test boolean _methodTwo(){
        return methodTwo() == 2;
    }
    //...
}
