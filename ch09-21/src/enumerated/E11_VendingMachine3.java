package enumerated;
/****************** Exercise 11 *****************
 * In a real vending machine you will want to easily
 * add and change the type of vended items, so the
 * limits imposed by an enum on Input are impractical
 * (remember that enums are for a restricted set of
 * types). Modify VendingMachine.java so that the
 * vended items are represented by a class instead
 * of being part of Input, and initialize an
 * ArrayList of these objects from a text file (using
 * net.mindview.util.TextFile).
 ***********************************************/

import jdk.internal.util.xml.impl.Input;

import java.util.*;

/**
 * Created by wangcheng  on 2017/12/22.
 */
class VendedItem{
    int amount;
    String name;
    VendedItem(String name,int amount){
        this.name = name;
        this.amount = amount;
    }
    // The data is expected to be in a format: <name> <amount>
    public static VendedItem parse(String data){
        String[] s = data.split(" ");
        return new VendedItem(s[0],Integer.parseInt(s[1]));
    }
    private static List<VendedItem> items =
            new ArrayList<VendedItem>();
    public static void addItem(VendedItem item){
        items.add(item);
    }
    //A very slow lookup procedure
    public static VendedItem lookup(String name){
        for(VendedItem item : items)
            if(item.name.equals(name))
                return item;
        return null;
    }
    private static Random rand = new Random(47);
    public static VendedItem randomSelection(){
        return items.get(rand.nextInt(items.size()));
    }
}
//A class representing an input to a state machine
class ExtInput{
    Input2 input;
    VendedItem item;
    ExtInput(Input2 input,VendedItem item){
        this.input = input;
        this.item = item;
    }
    public int amount(){
        return item != null ? item.amount : input.amount();
    }
    public String toString(){
        return item != null ? item.name : input.toString();
    }
}
enum Input2 {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    VENDED_ITEM,
    ABORT_TRANSACTION {
        public int amount() { // Disallow
            throw new RuntimeException("ABORT.amount()");
        } },
    STOP { // This must be the last instance.
        public int amount() { // Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    int value; // In cents
    Input2(int value) { this.value = value; }
    Input2() {}
    int amount() { return value; }; // In cents
    static Random rand = new Random(47);
    public static Input2 randomSelection() {
        // Don't include STOP:
        return values()[rand.nextInt(values().length - 1)];
    }
}
enum Category2 {
    MONEY(Input2.NICKEL, Input2.DIME, Input2.QUARTER,
            Input2.DOLLAR),
    ITEM_SELECTION(Input2.VENDED_ITEM),
    QUIT_TRANSACTION(Input2.ABORT_TRANSACTION),
    SHUT_DOWN(Input2.STOP);
    private Input2[] values;
    Category2(Input2... types) { values = types; }
    private static EnumMap<Input2,Category2> categories =
            new EnumMap<Input2,Category2>(Input2.class);
    static {
        for(Category2 c : Category2.class.getEnumConstants())
            for(Input2 type : c.values)
                categories.put(type, c);
    }
    public static Category2 categorize(Input2 input) {
        return categories.get(input);
    }
}

public class E11_VendingMachine3 {
}
