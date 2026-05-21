import java.util.Stack;

public class BalancedParenthesis {

    static boolean isOpening(char c) {
        if(c == '(' || c == '{' || c == '[') return true;
        else return false;
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isOpening(c)) stack.push(c);

            else {
                if(stack.isEmpty()) return false;

                char o = stack.pop();
                if(!((c == ')' && o == '(') || (c == '}' && o == '{') || (c == ']' && o == '['))) return false;
            }
        }

        return stack.isEmpty();

    }
    public static void main(String[] args) {
        String s = "()[{}";
        System.out.println(isValid(s));
    }
}
