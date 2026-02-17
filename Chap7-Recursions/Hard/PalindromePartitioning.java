import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    static boolean isPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
    static void doPartition(String s, int index, List<String> ds, List<List<String>> ans) {
        if(index == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            String part = s.substring(index, i+1);
            if(isPalindrome(part)) {
                ds.add(part);
                doPartition(s, i+1, ds, ans);

                ds.remove(ds.size() - 1);
            }
        }
    }

    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        doPartition(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> ans = partition(s);

        for(List<String> list: ans) {
            for(String str: list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
