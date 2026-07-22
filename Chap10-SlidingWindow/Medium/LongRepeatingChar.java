// Unsolved
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

    public static void main(String[] args) {
        String s = "BAABAABBBAAA";
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }
}
