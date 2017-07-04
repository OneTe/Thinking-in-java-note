package innerclasses;
//控制框架的完整实现是由单个的类创建的，从而使得实现的细节被封装起来.
//This produces a specific application of the control system.
//all in a single class .Inner classes allow you to encapsulate
//different functionlity for each type of event.
import innerclasses.controller.*;

/**
 * Created by wangcheng on 2017/7/3.
 */
public class GreehouseControls extends Controller{
    //exercise 24(turn on/off the fan)
    private boolean fan = false;
    public class FanOn extends Event{
        public FanOn(long delayTime){super(delayTime);}
        public void action(){
            //Put hardware control code here to
            //physically turn on the fan.
            fan = true;
        }
        public String toString(){return "Fan in on";}
    }
    public class FanOff extends Event{
        public FanOff(long delayTime){super(delayTime);}
        public void action(){
            //Put hardware control code here to physically turn off the fan.
            fan = false;
        }
        public String toString(){return "Fan in off";}
    }
    private boolean light = false;
    public class LightOn extends Event{
        public LightOn(long delayTime){super(delayTime);}
        public void action(){
            //Put hardware control code here to physically turn on the light.
            light = true;
        }
        public String toString(){return "Light is on";}
    }
    public class LightOff extends Event{
        public LightOff(long delayTime){super(delayTime);}
        public void action(){
            //Put hardware control code here to physically turn off the light.
            light = false;
        }
        public String toString(){return "Light is off";}
    }
    private boolean water = false;
    public class WaterOn extends Event{
        public WaterOn(long delayTime){super(delayTime);}
        public void action(){
            //Put hardware control code here
            water = true;
        }
        public String toString(){return "Greenhouse water is on";}
    }
    public class WaterOff extends Event{
        public WaterOff(long delayTime){super(delayTime);}
        public void action(){
            //Put hardware control code here
            water = false;
        }
        public String toString(){return "Greenhouse water is off";}
    }
    private String thermostat = "Day";
    public class ThermostatNight extends Event{
        public ThermostatNight(long delayTime){super(delayTime);}
        public  void action(){
            //Put hardware control code here.
            thermostat = "Night";
        }
        public String toString(){return "Thermostat on night setting";}
    }
    public class ThermostatDay extends Event{
        public ThermostatDay(long delayTime){super(delayTime);}
        public void action(){
            //Put hardware control code here.
            thermostat = "Day";
        }
        public String toString(){return "thermostat on Day setting";}
    }
    //An example of an action() that inserts a new one of itself into the event list:
    public class Bell extends Event{
        public Bell(long delayTime){super(delayTime);}
        public void action(){
            addEvent(new Bell(delayTime));
        }
        public String toString(){return "Bing!";}
    }
    public class Restart extends Event{
        private Event[] eventList;
        public Restart(long delayTime,Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList) {
                addEvent(e);
            }
        }
            public void action(){
                for(Event e : eventList){
                    e.start();
                    addEvent(e);
                }
                start();
                addEvent(this);
        }
        public String toString(){return "Restarting the system!";}
        }
    public static class Terminate extends Event{
        public Terminate(long delayTime){super(delayTime);}
        public void action(){System.exit(0);}
        public String toString(){return "Terminate";}
    }
}
