import java.util.HashMap;

public class IsomorphicStrings {
    // Brute force (TC -> 5nlogn, SC -> n);
    static boolean getIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int left = 0, right = 0;

        while (left < s.length()) {
            if(map.containsKey(s.charAt(left))) {
                Character val = map.get(s.charAt(left));
                // System.out.println(map.get(s.charAt(left)));


                // System.out.println(t.charAt(right));
                if(val != t.charAt(right)) return false;
                else  { left++; right++;}
            }
            else {
                if(map.containsValue(t.charAt(right)) && !map.containsKey(s.charAt(left))) return false;
                map.put(s.charAt(left++), t.charAt(right++));
                // System.out.println(s.charAt(left++) + " " + s.charAt(right++));
            } 
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "babc", t = "baba";
        System.out.println("Is it isomorphic " + getIsomorphic(s, t));
    }
}
