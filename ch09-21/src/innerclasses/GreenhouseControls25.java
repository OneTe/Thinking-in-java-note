package innerclasses;
// TIJ4 Chapter Innerclasses, Exercise 25, page 382
/* Inherit from GreenhouseControls in GreenhouseControls.java to add Event
* inner classes that turn water mist generators on and off. Write a new
* version of GreenhouseController.java to use these new Event objects.
*/

import innerclasses.controller.*;

/**
 * Created by wangcheng on 2017/7/4.
 */
public class GreenhouseControls25 extends GreehouseControls{
    private boolean waterMist = false;
    public class WaterMistOn extends Event{
        public WaterMistOn(long delayTime){super(delayTime);}
        public void action(){
            waterMist = true;
        }
        public String toString(){return "Water mist generator on";}
    }
    public class WaterMistOff extends Event{
        public WaterMistOff(long delayTime){super(delayTime);}
        public void action(){
            waterMist = false;
        }
        public String toString(){return "Water mist generator off";}
    }
}
