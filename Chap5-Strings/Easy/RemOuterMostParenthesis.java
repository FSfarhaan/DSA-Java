import java.util.Stack;

public class RemOuterMostParenthesis {
    // Brute force(TC -> n, SC -> n/2);
    static String remOuterParenthesis(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int lastIndex = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.add('(');
            else {
                stack.pop();
                if(stack.isEmpty()) {
                    String valid = s.substring(lastIndex+1, i);
                    ans.append(valid);

                    lastIndex = i + 1;
                }
            }
        }
        return ans.toString();
    }

    // Optimal approach (TC -> n, SC -> 1);
    static String BetRemOuterParenthesis(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        int lastIndex = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            else {
                count--;
                if(count == 0) {
                    ans.append(s.substring(lastIndex+1, i));
                    lastIndex = i + 1;
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
       String s = "(()())(())";
       System.out.println(BetRemOuterParenthesis(s)); 
    }
}