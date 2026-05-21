class AStack {
    int top = -1;
    int[] stack = new int[10];

    public void push(int n) {
        if(top == 10) {
            System.out.println("Stack is already full");
            return;
        }
        stack[++top] = n;
    }

    public void pop() {
        if(top == -1) {
            System.out.println("Stack is already empty");
            return;
        }
        top--;
    }

    public void peek() {
        if(top == -1) {
            System.out.println("Stack is already empty");
            return;
        }
        System.out.println(stack[top]);
    }
}

class AQueue {
    int left = -1, right = -1;
    int MAX = 10;
    int[] queue = new int[MAX];

    public void push(int n) {
        if((right > left && (right - left) == (MAX-1)) || 
            (left > right && (left - right == 1))) {
            System.out.println("Queue is already full");
            return;   
        }

        right = (right + 1) % MAX;
        queue[right] = n;
        if(left == -1) left = 0;
    }

    public void pop() {
        if(left == -1) {
            System.out.println("Queue is already empty");
            return;
        }

        if(left == right) {
            left = right = -1;
            return;
        }

        left = (left + 1) % MAX;
    }

    public void peek() {
        if(left == -1) {
            System.out.println("Queue is already empty");
            return;
        }
        System.out.println(queue[left]);
    }
}

class LStack {
    class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    private Node top;

    public LStack() {
        top = null;
    }

    public void push(int n) {
        Node temp = new Node(n);
        temp.next = top;
        top = temp;
    }

    public void pop() {
        if(top == null) {
            System.out.println("Stack is already empty");
            return;
        }

        top = top.next;
    }

    public void peek() {
        if(top == null) {
            System.out.println("Stack is already empty");
            return;
        }
        System.out.println(top.val);
    }
}

class LQueue {
    
    class Node {
        private int val;
        private Node next;
        
        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node left;
    private Node right;

    public LQueue() {
        left = right = null;
    }

    public void push(int n) {
        Node temp = new Node(n);
        if(left == null) {
            right = left = temp;
            return;
        }
        right.next = temp;
        right = temp;
    }

    public void pop() {
        if(left == null) {
            System.out.println("Queue is already empty");
            return;
        }
        if(left == right) {
            left = right = null;
            return;
        }
        left = left.next;
    }

    public void peek() {
        if(right == null) {
            System.out.println("Queue is already empty");
            return;
        }
        System.out.println(left.val);
    }

}

public class Basics {
   public static void main(String[] args) {
        // Implementing Stack Using Arrays
        // AStack st = new AStack();
        // st.pop();
        // st.push(12);
        // st.push(15);
        // st.push(2);
        // st.push(7);
        // st.push(10);
        // st.peek();
        // st.pop();
        // st.peek();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();

        // Implementing Queue using Array
        // AQueue queue = new AQueue();
        // queue.pop();
        // queue.peek();
        // queue.push(4);
        // queue.push(34);
        // queue.push(8);
        // queue.peek();
        // queue.push(10);
        // queue.push(2);
        // queue.push(14);
        // queue.peek();
        // queue.pop();
        // queue.pop();
        // queue.pop();
        // queue.peek();
        // queue.pop();
        // queue.pop();
        // queue.pop();
        // queue.pop();

        // Implementing Stack using LinkedList
        // LStack st = new LStack();
        // st.pop();
        // st.push(12);
        // st.push(15);
        // st.push(2);
        // st.push(7);
        // st.push(10);
        // st.peek();
        // st.pop();
        // st.peek();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();

        // Implementing Queue using LinkedList
        LQueue queue = new LQueue();
        queue.pop();
        queue.peek();
        queue.push(4);
        queue.push(34);
        queue.push(8);
        queue.peek();
        queue.push(10);
        queue.push(2);
        queue.push(14);
        queue.peek();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.peek();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
   }     
}
