package net.mindview.util;
//Run an operating system command and send the output to the console
/**
 * Created by wangcheng  on 2017/12/7.
 */
import java.io.*;

public class OSExecute {
    public static void command(String command){
        boolean err = false;
        try{
            Process process =
                    new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String s;
            while ((s = results.readLine())!=null)
                System.out.println(s);
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );
            while ((s = errors.readLine())!=null){
                System.err.println(s);
                err = true;
            }
        }catch (Exception e){
            if(!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        }
        if(err)
            throw new OSExecuteException("Errors executing " + command);
    }
}
