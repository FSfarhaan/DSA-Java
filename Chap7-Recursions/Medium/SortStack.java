import java.util.ArrayList;
import java.util.Stack;

public class SortStack {

    // Brute force (TC -> 2n + nlogn, SC -> 2n);
    static Stack<Integer> sortStack(Stack<Integer> stack) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = stack.size();
        for(int i = 0; i < n; i++) {
            list.add(stack.pop());
        }
        list.sort(null);

        Stack<Integer> ans = new Stack<>();
        for(int i = 0; i < list.size(); i++) {
            ans.push(list.get(i));
        }

        return ans;
    }

    
    static void mergeStack(int top, Stack<Integer> stack) {
        if(stack.isEmpty() || stack.peek() <= top) {
            stack.push(top);
            return;
        }

        int val = stack.pop();
        mergeStack(top, stack);

        stack.push(val);

    }


    // Better approach
    static void BetSortStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return;

        int top = stack.pop();
        BetSortStack(stack);
        mergeStack(top, stack);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        BetSortStack(stack);        
        for(int i : stack) {
            System.out.println(i);
        }
    }
}
