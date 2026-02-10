import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    // Brute force (Partially correct) (TC -> 3nlogn + 3nlogn + nlogn, SC -> 2n);
    static boolean getValidAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int n = s.length();
        for(int i = 0; i < n; i++) {
            int times = map1.getOrDefault(s.charAt(i), 0);
            map1.put(s.charAt(i), ++times);
        }

        for(int i = 0; i < n; i++) {
            if(!map1.containsKey(t.charAt(i))) return false;
            int times = map2.getOrDefault(t.charAt(i), 0);
            map2.put(t.charAt(i), ++times);
        }

        for(int i = 0; i < s.length(); i++) {
            // System.out.println("Idhar tak pohcha?");
            if(map1.get(s.charAt(i)) != map2.get(s.charAt(i))) return false;
        }

        return true;
    }

    // Better Approach
    static boolean BetValidAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);

        for (int i = 0; i < s.length(); i++) {
            if (s1[i] != t1[i]) {
                return false;
            }
        }

        return true;
    }

    // Optimal approach (TC -> 3n, SC -> 1);
    static boolean OptGetvalidAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;

        int[] freq= new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for(int j = 0; j < t.length(); j++) {
            freq[t.charAt(j) - 'a']--;
        }

        for(int k = 0; k < 26; k++) {
            if(freq[k] != 0) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println(getValidAnagram(s, t));
        // System.out.println();        
    }
}
