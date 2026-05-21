import java.util.LinkedList;
import java.util.Stack;

class SQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    
    public SQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(x);

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
    
    public int pop() {
        return s2.pop();
    }
    
    public int peek() {
        return s2.peek();
    }
    
    public boolean empty() {
        return s2.isEmpty();
    }
    
}

public class QueueUsingStack {
    public static void main(String[] args) {
        
    }
}
