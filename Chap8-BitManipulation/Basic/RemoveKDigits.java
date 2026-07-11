import java.util.Stack;

public class RemoveKDigits {

    static String removeKdigits(String num, int k) {
      StringBuilder ans = new StringBuilder();
      Stack<Character> stack = new Stack<>();
      int n = num.length();

      for(int i = 0; i < n; i++) {
        while (!stack.isEmpty() && k > 0 && stack.peek() - '0' > num.charAt(i) - '0') {
            stack.pop();
            k--;
        }

        stack.push(num.charAt(i));
      }

      while (k > 0) {
        stack.pop();
        k--;
      }

      if(stack.isEmpty()) return "0";

      while (!stack.isEmpty()) {
        ans.append(stack.pop());
      }
      
      while (ans.length() > 0 && ans.charAt(ans.length() - 1) == '0') {
        ans.deleteCharAt(ans.length() - 1);
      }

      ans.reverse();

      if(ans.length() == 0) return "0";

      return ans.toString();
    } 
    public static void main(String[] args) {
        String num = "112";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }
}
