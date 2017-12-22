package enumerated;
/****************** Exercise 10 *****************
 * Modify class VendingMachine (only) using EnumMap
 * so that one program can have multiple instances
 * of VendingMachine.
 ***********************************************/
/**
 * Created by wangcheng  on 2017/12/22.
 */
import net.mindview.util.Generator;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;


class VendingMachine2{
    //NEWLY ADDED CODE: BEGIN
    private static class Context{
        private State state = State.RESTING;
        private int amount;
        private Input selection;
    }
    private static Map<Machine,Context> em =
            Collections.synchronizedMap(new EnumMap<Machine, Context>(Machine.class));
    static{
        for(Machine m : Machine.values())
            em.put(m,new Context());
    }
    enum Machine{M1,M2,M3}
    private static final ReentrantLock lock =
            new ReentrantLock();
    //NEWLY ADDED CODE: END
    private static State state;
    private static int amount;
    private static Input selection;
    enum StateDuration{TRANSIENT}
    //...
    enum State {
        RESTING {
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default: }
            } },
        ADDING_MONEY {
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if(amount < selection.amount())
                            System.out.println("Insufficient money for " + selection);
                        else state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default: }
            } },
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            } },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if(amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0; }
                state = RESTING;
            }
        },
        TERMINAL { void output() { System.out.println("Halted"); } };
    private boolean isTransient = false;
    State(){}
    State(StateDuration trans){isTransient = true;}
    void next(Input input){
        throw new RuntimeException("Only call " + "next(Input input) for non-transient states");
    }
    void next() {
        throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
    }
    void output() { System.out.println(amount); }
    }
    static void run (Generator<Input> gen, Machine m){
        Context ctx = em.get(m);
        while (ctx.state != State.TERMINAL){
            lock.lock();
            state = ctx.state;
            amount = ctx.amount;
            selection = ctx.selection;
            try {
                state.next(gen.next());
                while (state.isTransient)
                    state.next();
                state.output();
                ctx.state = state;
                ctx.amount = amount;
                ctx.selection = selection;
                em.put(m,ctx);
            }finally {
                lock.unlock();
            }
            Thread.yield();
        }
    }
}
public class E10_VendingMachine2 {
    public static void main(String[] args){
        for(final VendingMachine2.Machine m : VendingMachine2.Machine.values()){
                Generator<Input> gen = new RandomInputGenerator();
            gen = new FileInputGenerator("src/enumerated/VendingMachineInput.txt");
            final Generator<Input> g = gen;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    VendingMachine2.run(g,m);
                }
            }).start();
        }
    }
}
