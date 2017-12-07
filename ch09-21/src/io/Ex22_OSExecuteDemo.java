package io;

import java.util.LinkedList;
import java.util.List;
import java.io.*;
import net.mindview.util.*;

/**
 * Created by wangcheng  on 2017/12/7.
 */
class OSExecute2{
    public static List<String> command(String command){
        boolean err = false;
        List<String> output = new LinkedList<>();
        try{
            Process process =
                    new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s;
            while((s = results.readLine()) != null)
                output.add(s);
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            // Report errors and return nonzero value
            // to calling process if there are problems:
            while((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true; }
        } catch(IOException e) {
            if(!command.startsWith("CMD /C"))
                return command("CMD /C " + command);
            throw new RuntimeException(e);
        } catch(Exception e) {
            throw new RuntimeException(e);
        } if(err)
            throw new OSExecuteException("Errors executing " +
                    command);
        return output;
    }
}
public class Ex22_OSExecuteDemo {
    public static void main(String[] args){
        List<String> result =
                OSExecute2.command("javap Ex22_OSExecuteDemo");
        for(String s : result){
            System.out.println(s);
        }
    }
}
