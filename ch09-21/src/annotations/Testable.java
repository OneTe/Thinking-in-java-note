package annotations;

import net.mindview.atunit.Test;

/**
 * Created by wangcheng  on 2017/12/22.
 */
public class Testable {
    public void execute(){
        System.out.println("Executing....");
    }
    @Test
    void testExecute(){execute();}
}
