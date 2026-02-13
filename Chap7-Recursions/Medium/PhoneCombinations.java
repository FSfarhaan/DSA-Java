import java.util.ArrayList;
import java.util.List;

class Solution {
    String map[];
    public Solution() {
        map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }

    public void getCombinations(String digits, int index, String current, List<String> ans) {
        if(index == digits.length()) {
            ans.add(current);
            return;
        }

        String s = map[digits.charAt(index) - '0'];

        for(int i = 0; i < s.length(); i++) {

            getCombinations(digits, index+1, current + s.charAt(i), ans);
        }
    }
}
public class PhoneCombinations {
    static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();   
        if(digits.isEmpty()) return ans;
        Solution sol = new Solution();
        sol.getCombinations(digits, 0, "", ans);
        return ans;
    }
    public static void main(String[] args) {
        String s = "";
        List<String> ans = letterCombinations(s);

        for(String str: ans) {
            System.out.println(str);
        }
    }
}
