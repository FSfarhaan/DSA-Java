import java.util.Date;

public class LongestPalindromicSubstring {

    static boolean isPalindrome(String s, int n) {
        for(int i = 0; i < n / 2; i++) {
            if(s.charAt(i) != s.charAt(n-i-1)) return false;
        }
        return true;
    }

    // Brute force (TC -> n3, SC -> 1) (TLE);
    static String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;

        String longest = "";

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {

                String substr = s.substring(i, j+1);
                if(isPalindrome(substr, substr.length())) {
                    if(substr.length() > longest.length()) longest = substr;
                }
            }
        }

        return longest;
    }

    static String expandFromCentre(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; right++;
        }

        return s.substring(left+1, right);
    }

    // Better approach (TC -> n2, SC -> 1);
    static String BetLongestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;

        String longest = "";

        for(int i = 0; i < n; i++) {
            String odd = expandFromCentre(s, i, i);
            String even = expandFromCentre(s, i, i+1);

            if(odd.length() > longest.length()) longest = odd;
            if(even.length() > longest.length()) longest = even;
        }

        return longest;
    }

    // Better approach
    public static void main(String[] args) {
        String s = "borcdubqiupahpwjizjjbkncelfazeqynfbrnzuvbhjnyvrlkdyfyjjxnprfocrmisugizsgvhszooktdwhehojbrdbtgkiwkhpfjfcstwcajiuediebdhukqnroxbgtvottummbypokdljjvnthcbesoyigscekrqswdpalnjnhcnqrarxuufzzmkwizptyvjhpfidgmskuaggtpxqisdlyloznkarxofzeeyvteynluofuhbllyiszszbwnsglqjkignusarxsjvctpgiwnhdufmfpanfwxjwlmhgllzsmdpncbwnsbdtsvrjybynifywkulqnzprcxockbhrhvnwxrkvwumyieazclcviumvormynbryaziijpdinwatwqppamfiqfiojgwkvfzyxadyfjrgmtttvlgkqghgbcfhkigfojjkhskzenlpasyozcsuccdxhulcubsgomvcrbqwakrraesfifecmoztayrdjicypakrrneulfbqqxtrdelggedvloebqaztmfyfkhuonrognejxpesmwgnmnnnamvkxqvzrgzdqtvuhccryeowywmbixktnkqnwzlzfvloyqcageugmjqihyjxhssmhkfzxpzxmgpjgsduogfolnkkqizitbvvgrkczmojxnabruwwzxxqcevdwvtiigwckpxnnxxxdhxpgomncttjutrsvyrqcfwxhexhaguddkiesmfrqfjfdaqbkeqinwicphktffuwcazlmerdhraufbpcznbuipmymipxbsdhuesmcwnkdvilqbnkaglloswcpqzdggnhjdkkumfuzihilrpcvemwllicoqiugobhrwdxtoefynqmccamhdtxujfudbglmiwqklriolqfkknbmindxtljulnxhipsieyohnczddabrxzjmompbtnnxvivmoyfzfrxlufowtqzojfclmatthjtbhotdoheusnpirwicbtyrcuojsdmfcx";
        long before = System.currentTimeMillis();

        System.out.println(before);
        System.out.println(BetLongestPalindrome(s));

        long after = System.currentTimeMillis();

        System.out.println(after);
        
        System.out.println("Total time taken " + (after - before));
    }
}
