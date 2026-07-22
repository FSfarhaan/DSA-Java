public class Substring3Chars {

    // Brute force (TC -> n2, SC -> 3);
    static int numberOfSubstrings(String s) {
        int n = s.length();
        int sum = 0;

        for(int i = 0; i < n; i++) {
            int[] map = new int[] { 0, 0, 0};
    
            for(int j = i; j < n; j++) {
                char c = s.charAt(j);
                map[c - 'a']++;

                if(map[0] != 0 && map[1] != 0 && map[2] != 0) {
                    sum += n - j;
                    break;
                }
            }
        }

        return sum;
    }

    // Better approach (TC -> 2n, SC -> 3); 
    static int BetNumberOfSubstrings(String s) {
        int n = s.length(); // 6
        int sum = 0;
        int l = 0, r = 0;
        int[] freq = { 0, 0, 0 };

        while (r < n) {
            char c = s.charAt(r);
            freq[c - 'a']++;

            if(freq[0] != 0 && freq[1] != 0 && freq[2] != 0) {
                sum += n - r;

                freq[s.charAt(l) - 'a']--;
                freq[c- 'a']--;
                l++;
                continue;
            }
            r++;
        }

        return sum;
    }


    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabc";
        System.out.println(BetNumberOfSubstrings(s));
    }
}
