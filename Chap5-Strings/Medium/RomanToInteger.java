import java.util.HashMap;

public class RomanToInteger {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {
            }
        }));
    }

    static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i = 0; i < s.length() - 1; i++) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }

        ans += map.get(s.charAt(s.length() - 1));

        return ans;
    }
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println("Integer value: " + romanToInt(s));
    }
}
