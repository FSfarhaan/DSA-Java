import java.util.Stack;

class MyMinStack {
    class Node {
        int ele;
        int min;

        public Node(int ele, int min) {
            this.ele = ele;
            this.min = min;
        }
    }

    Stack<Node> stack;

    public MyMinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty())
            stack.push(new Node(x, x));

        int currMin = stack.peek().min;
        int newMin = currMin;
        if (x < currMin)
            newMin = x;

        stack.push(new Node(x, newMin));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().ele;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

public class MinStack {

    public static void main(String[] args) {
        MyMinStack minStack = new MyMinStack();

        minStack.push(5);  
        minStack.push(11);  
        System.out.println(minStack.getMin()); // returns 1  
        minStack.push(3);  
        System.out.println(minStack.getMin()); // returns 1  
        System.out.println(minStack.top()); // returns 1
    }
}
