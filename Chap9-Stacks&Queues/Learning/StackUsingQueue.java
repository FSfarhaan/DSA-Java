import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

class QStack {
    Queue<Integer> q;
    public QStack() {
        q = new LinkedList<>();
    }
    
    public void push(int n) {
        int s = q.size();

        q.add(n);
        for(int i = 0; i < s; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();   
    }
}

public class StackUsingQueue {
    
    public static void main(String[] args) {
        QStack stack = new QStack();

    }
}
