import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BeautyOfSubstring {
    // TC -> n2, SC -> n2
    static ArrayList<String> getSubstrings(String s) {
        ArrayList<String> ans = new ArrayList<>();
        int n = s.length(), window = 3;

        for(int i = 0; i + window <= n; i++) {
            for(int j = i + window; j <= n; j++) {
                ans.add(s.substring(i, j));
            }
        }
        return ans;
    }

    // TC -> 3logn, SC -> n
    static int getBeauty(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            int times = map.getOrDefault(c, 0);
            map.put(c, ++times);
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
            min = Math.min(min, entry.getValue());
        }
        return max - min;
    }

    // Brute force (TC -> n2 + 3n2logn)
    static int beautySum(String s) {
        int sum = 0;
        ArrayList<String> list = getSubstrings(s);
        for(String str: list) {
            int beauty = getBeauty(str);
            sum += beauty;
        }
        return sum;
    }

    static int BetGetBeauty(int [] freq) {
        int max = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] != 0) {
                max = Math.max(max, freq[i]);
                min = Math.min(min, freq[i]);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : max - min;
    }

    // Better approach (TC -> 26*n2, SC -> 1);
    static int BetBeautySum(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            int []freq = new int[26];

            for(int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                ans += BetGetBeauty(freq);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "aabcbaa";
        System.out.println(BetBeautySum(s));
    }
}
