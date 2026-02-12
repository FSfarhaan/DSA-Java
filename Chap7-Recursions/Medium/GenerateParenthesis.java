import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    static boolean isValidParenthesis(StringBuilder s) {
        int tracker = 0;
        // System.out.println("Iske liye aaya tha " + s);
        for(int i = 0; i < s.length(); i++) {
            if(tracker < 0) return false;
            if(s.charAt(i) == '(') tracker++;
            else if(s.charAt(i) == ')') tracker--;
        }
        return tracker == 0;
    }

    // Brute force (Creating all subsequences, and then finding is it valid or not);
    static void generateSS(int n, StringBuilder s, List<String> ans) {
        if(s.length() == n) {
            if(isValidParenthesis(s)) {
                ans.add(s.toString());
            }
            return;
        }

        s.append("(");
        generateSS(n, s, ans);

        s.deleteCharAt(s.length() - 1);

        s.append(")");
        generateSS(n, s, ans);
        s.deleteCharAt(s.length() - 1);
    }

    // Optimal approach (TC -> 2^n, SC -> number of valid strings);
    static void OptGenerateSS(int n, int open, int close, StringBuilder s, List<String> ans) {
        if(s.length() == n) {
            ans.add(s.toString());
            return;
        }

        if(open < n / 2) {
            s.append("(");
            OptGenerateSS(n, open+1, close, s, ans);
            s.deleteCharAt(s.length() - 1);
        }

        if(close < open) {
            s.append(")");
            OptGenerateSS(n, open, close+1, s, ans);
            s.deleteCharAt(s.length() - 1);
        }
    }
    static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder("");
        
        OptGenerateSS(n+n, 0, 0, s, ans);
        return ans;

    }
    public static void main(String[] args) {
        int n = 4;
        List<String> ans = generateParenthesis(n);
        // System.out.println(ans.size());
        for(String s: ans) {
            System.out.println(s);
        }
    }
}
