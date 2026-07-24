public class LongRepeatingChar {

    // Brute force
    static int characterReplacement(String s, int k) {
        int n = s.length();
        int max = 0;

        for(int i = 0; i < n; i++) {
            int bs = 0;
            for(int j = i; j < n; j++) {
                if(s.charAt(j) != 'A') bs++;

                if(bs <= k) max = Math.max(max, j - i + 1);
                else break;
            }
        }
        return max;
    }

    // Optimal approach
    static int BetCharacterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int[] freqMap = new int[26];
        int maxFreq = 0, longest = 0;

        while (r < n) {
            char c = s.charAt(r);

            freqMap[c -'A']++;
            maxFreq = Math.max(maxFreq, freqMap[c - 'A']);

            while ((r - l + 1) - maxFreq > k) {
                char p = s.charAt(l);
                freqMap[p - 'A']--;
                l++;
            }

            if((r - l + 1) - maxFreq <= k) longest = Math.max(longest, r - l + 1);

            r++;
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(BetCharacterReplacement(s, k));
    }
}
