import java.util.Arrays;

public class LongestCommonPrefix {
    // (TC -> nlogn + first.length, SC -> 1)
    static String getPrefix(String[] input) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(input);

        String first = input[0];
        String last = input[input.length - 1];
        for(int i = 0; i < Math.min(first.length(), last.length()) ; i++) {
            if(first.charAt(i) != last.charAt(i)) return ans.toString();
            ans.append(first.charAt(i));
        }

        return ans.toString();
    }
    public static void main(String[] args) {
        String[] input = {"dog","racecar","car"};
        System.out.println("Prefix " + getPrefix(input));
    }
}
