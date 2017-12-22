package enumerated;
/****************** Exercise 9 *****************
 * Modify class PostOffice so that it uses an
 * EnumMap.
 ***********************************************/
/**
 * Created by wangcheng  on 2017/12/20.
 */
import java.util.*;

interface Command{boolean handle(Mail m);}

public class E09_PostOffice2 {
    static EnumMap<MailHandler,Command> em =
            new EnumMap<MailHandler, Command>(MailHandler.class);
    static {
        em.put(MailHandler.GENERAL_DELIVERY, new Command() {
            @Override
            public boolean handle(Mail m) {
                switch (m.generalDelivery){
                    case YES:
                        System.out.print("Using general delivery for " + m);
                        return true;
                    default:return false;
                }
            }
        });
        em.put(MailHandler.MACHINE_SCAN, new Command() {
            @Override
            public boolean handle(Mail m) {
                switch (m.scannability){
                    case UNSCANNABLE:return false;
                    default:
                        switch (m.address){
                            case INCORRECT:return false;
                        default:
                            System.out.print("Delivering "  + m + " automatically");
                            return true;
                        }
                }
            }
        });
        em.put(MailHandler.VISUAL_INSPECTION, new Command() {
            public boolean handle(Mail m) {
                switch(m.readability) {
                    case ILLEGIBLE: return false;
                    default:
                        switch(m.address) {
                            case INCORRECT: return false;
                            default:
                                System.out.print("Delivering " + m + " normally");
                                return true;
                        }
                } }
        });
        em.put(MailHandler.RETURN_TO_SENDER, new Command() {
            public boolean handle(Mail m) {
                switch(m.returnAddress) {
                    case MISSING: return false;
                    default:
                        System.out.print("Returning " + m + " to sender");
                        return true;
                }
            }
        });
    }

    enum MailHandler{
        GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION,
        RETURN_TO_SENDER;
    }
    static void handle(Mail m){
        for(Command cmd : em.values()){
            if(cmd.handle(m))
                return;
            System.out.println(m + " is a dead letter");
        }
    }
    public static void main(String[] args){
        for(Mail mail : Mail.generator(10)){
            System.out.println(mail.details());
            handle(mail);
            System.out.println("********");
        }
    }
}
