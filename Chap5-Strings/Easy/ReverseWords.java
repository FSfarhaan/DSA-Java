import java.util.Stack;

public class ReverseWords {
    // Brute force
    static String reverseString(String s) {
        String trimmed = s.trim() + " ";
        Stack<String> stack = new Stack<>();
        int lastIndex = 0;

        // s = "hello world";

        for(int i = 0; i < trimmed.length(); i++) {
            if(trimmed.charAt(i) == ' ' || i == trimmed.length() - 1) {
                stack.add(trimmed.substring(lastIndex, i+1));
                // System.out.println(trimmed.substring(lastIndex, i+1/,mnb));

                while (i < trimmed.length() && trimmed.charAt(i) == ' ') {
                    i++;
                }
                lastIndex = i;
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.toString().trim();
    }

    // Optimal Approach (TC -> n, SC -> 1);
    static String OptReverse(String s) {
        StringBuilder ans = new StringBuilder();
        String trimmed = s.trim();
        int lastIndex = trimmed.length(), i = lastIndex - 1;
         while (i >= 0) {
            if (trimmed.charAt(i) == ' ') {
                ans.append(trimmed.substring(i + 1, lastIndex)).append(' ');
                while (i >= 0 && trimmed.charAt(i) == ' ') i--;
                lastIndex = i + 1;
            } else {
                i--;
            }
        }

        ans.append(trimmed.substring(0, lastIndex));

        return ans.toString().trim();
    }
    public static void main(String[] args) {
        String s = " a good   example   ";

        System.out.println(OptReverse(s));
    }
}
