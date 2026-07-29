public class MinWindowSubstring {

    // Optimal approach (TC -> n + m, SC -> 256)
    static String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, sIndex = -1;
        int count = 0;
        int[] freq = new int[256];
        
        for (char c : t.toCharArray()) freq[c]++;

        while (r < n) {

            freq[s.charAt(r)]--;
            if(freq[s.charAt(r)] >= 0) {
                count++;
            }

            while(count == m) {
                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)] > 0) count--;
                l++;
            }

            r++;
        }
        return sIndex == -1 ? "Kuch nahi hua hehe" : s.substring(sIndex, sIndex + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}