package exceptions;
//An exception that reports through a Logger.

import com.sun.javafx.binding.*;

import java.util.logging.*;
import java.io.*;
/**
 * Created by wangcheng on 2017/8/17.
 */
class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException1");
    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
public class LoggingExceptions {
    public static void main(String[] args){
        try {
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        }catch (LoggingException e){
            System.err.println("Caught " + e);
        }
    }
}
