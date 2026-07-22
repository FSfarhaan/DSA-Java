import java.util.HashMap;
import java.util.HashSet;

public class FruitsIntoBaskets {

    // Brute force (TC -> n2, SC -> 3);
    static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j < n; j++) {
                set.add(fruits[j]);

                if(set.size() <= 2) {
                    int len = j - i + 1;
                    max = Math.max(max, len);
                } else break;
            }
        }
        return max;
    }

    // Better approach (TC -> 2n, SC -> 3);
    static int BetTotalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0, r = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            if(map.size() <= 2) {
                int len = r - l + 1;
                max = Math.max(max, len);
            } else {
                while (map.size() > 2) {
                    map.put(fruits[l], map.get(fruits[l]) - 1);
                    if(map.getOrDefault(fruits[l], 0) == 0) map.remove(fruits[l]);
                    l++;
                }
            }
            r++;
        }
        return max;
    }

    // Optimal approach
    static int OptTotalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0, r = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            if(map.size() <= 2) {
                int len = r - l + 1;
                max = Math.max(max, len);
            } else {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if(map.getOrDefault(fruits[l], 0) == 0) map.remove(fruits[l]);
                l++;
            }

            r++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] fruits = { 3,3,3,1,2,1,1,2,3,3,4 };
        System.out.println(OptTotalFruit(fruits));
    }
}
