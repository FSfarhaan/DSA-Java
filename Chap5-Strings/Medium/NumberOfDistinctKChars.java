import java.util.HashSet;

public class NumberOfDistinctKChars {

    static int getSubstrings(String s, int k) {
        int nos = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j = i; j < n; j++) {
                set.add(s.charAt(i));

                if(set.size() >= k) {
                    nos++;
                }
            }
        }
        return nos;
    }
    public static void main(String[] args) {
        String s = "pqpqs"; 
        int k = 2 ;
        System.out.println(getSubstrings(s, k));
    }
}
