import java.util.Stack;

public class ReverseStack {
    // Brute force (TC -> n, SC -> n);
    static Stack<Integer> reverseSt(Stack<Integer> stack) {
        Stack<Integer> helper = new Stack<>();
        int n = stack.size();
        for(int i = 0; i < n; i++) {
            helper.push(stack.pop());
        }
        return helper;
    }

    static void insertAtBottom(Stack<Integer> stack, int top) {
        if(stack.isEmpty()) {
            stack.push(top); return;
        }

        int temp = stack.pop();
        insertAtBottom(stack, top);
        stack.push(temp);
    }

    // Better approach
    static void BetReverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int top = stack.pop();
        BetReverseStack(stack);
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        

        BetReverseStack(stack);
        for(int it: stack) {
            System.out.println(it);
        }
    }
}
