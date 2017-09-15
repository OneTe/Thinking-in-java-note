package generics;
/* Remove the type parameter on the Node class and modify the rest of the
* code in LinkedStack.java to show that an inner class has access to the
* generic type parameters of its outer class.
/**
 * Created by wangcheng  on 2017/9/15.
 */
public  class LinkedStack5<T> {
    // make Node a nonstatic class to access nonstatic T:
    //这里不能使用static内部类，因为static内部类不能使用任何外围类的非static成员变量和方法
        private  class Node {
            T item;
            Node next;

            Node() {
                item = null;
                next = null;
            }

            Node(T item, Node next) {
                this.item = item;
                this.next = next;
            }

            boolean end() {
                return item == null && next == null;
            }
        }

        private Node top = new Node();

        public void push(T item) {
            top = new Node(item, top);
        }

        public T pop() {
            T result = top.item;
            if (!top.end()) {
                top = top.next;
            }
            return result;
        }

        public static void main(String[] args) {
            LinkedStack<String> lss = new LinkedStack<>();
            for (String s : "Phasers on stun!".split(" ")) {
                lss.push(s);
            }
            String s;
            while ((s = lss.pop()) != null) {
                System.out.println(s);
            }
        }
}
