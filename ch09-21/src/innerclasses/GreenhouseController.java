package innerclasses;
//Configure and execute the greenhouse system
//{Args:5000}
import innerclasses.controller.*;
/**
 * Created by wangcheng on 2017/7/4.
 */
public class GreenhouseController {
    public static void main(String[] args){
        GreehouseControls gc = new GreehouseControls();
        //Instead of hard-wiring ,you would parse configuration information from
        //a text filee here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
            gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new FanOn(300),
                gc.new LightOff(400),
                gc.new FanOff(500),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1600),
        };
        gc.addEvent(gc.new Restart(2000,eventList));
        if (args.length == 1){
            gc.addEvent(
                    new GreehouseControls.Terminate(new Integer(args[0]))
            );
        }
        gc.run();
    }
}
