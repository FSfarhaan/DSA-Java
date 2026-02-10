public class RotateString {
    // Brute force, partially correct. Failed for s ="defdefdefabcabc" goal = "defdefabcabcdef"
    static boolean getRotate(String s, String goal) {
        if(s.equals(goal)) return true;
        if(s.length() != goal.length()) return false;

        Character c = goal.charAt(0);
        int index = s.indexOf(c);
        if(index == -1) return false;

        for(int i = 0; i < goal.length(); i++) {
            if(goal.charAt(i) != s.charAt(index % goal.length())) return false;
            index++;
        }
        return true;
    }

    static String doRotation(String s, int rotations) {
        String start = s.substring(0, rotations);
        String end = s.substring(rotations, s.length());
        String ans = end + start;
        return ans;
    }

    // brute force (TC -> n2, SC -> n);
    static boolean getRotate2(String s, String goal) {
        if(s.equals(goal)) return true;
        if(s.length() != goal.length()) return false;

        for(int i = 1; i < s.length(); i++) {
            String rotated = doRotation(s, i);
            if(rotated.equals(goal)) return true;
        }
        return false;
    }

    // Optimal approach (TC-> n, SC -> n);
    static boolean OptGetRotate(String s, String goal) {
        if(s.equals(goal)) return true;
        if(s.length() != goal.length()) return false;

        String doubled = s + s;
        return doubled.contains(goal);
    }
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(getRotate2(s, goal));
    }
}
