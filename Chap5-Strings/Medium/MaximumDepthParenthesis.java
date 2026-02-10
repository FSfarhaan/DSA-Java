import java.util.Stack;

public class MaximumDepthParenthesis {

    // Brute force (TC -> n, SC -> n)
    static int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add('(');
                max = Math.max(max, stack.size());
            } else if(s.charAt(i) == ')') stack.pop();
        }

        return max;
    }

    // Optimal Approach (TC -> n, SC -> 1);
    static int BetMaxDepth(String s) {
        int counter = 0;
        int max = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                counter++;
                max = Math.max(max, counter);
            } else if(s.charAt(i) == ')') counter--;
        }

        return max;
    }
    public static void main(String[] args) {
        String s = "()(())";
        System.out.println("Max depth: " + BetMaxDepth(s));
    }
}
