public class LongestSubstring {

    // Brute force (TC -> n2, SC -> 256);
    static int getLongest(String s) {
        int max = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            int[] freq = new int[255];
            int len = 0;
            for(int j = i; j < n; j++) {
                char c = s.charAt(j);
                if(freq[c] == 1) break;

                freq[c] = 1;
                len = j - i + 1;
                max = Math.max(max, len);
            }
        }
        return max;
    }

    // Optimal approach (TC -> n + 256, SC -> 256);
    static int OptGetLongest(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int max = 0;
        int[] freq = new int[255];

        int i = 0;
        while (i < 256) {
            freq[i] = -1;
            i++;
        }

        while (r < n) {
            char c = s.charAt(r);
            
            int len = 0;
            if(freq[c] == -1 || (freq[c] != -1 && l > freq[c])) {
                len = r - l + 1;
                max = Math.max(max, len);
                freq[c] = r;
            } else {
                l = freq[c] + 1;
                freq[c] = r;
            }
            r++;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "aaabbbccc";
        System.out.println(getLongest(s));
    }
}
