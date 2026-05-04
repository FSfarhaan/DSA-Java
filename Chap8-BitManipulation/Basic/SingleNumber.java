import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    // Brute force (TC -> nlogn + n/2 + 1, SC -> n / 2 + 1);
    static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) return entry.getKey();
        }

        return 0;
    }

    // Optimal approach
    static int OptSingleNumber(int[] nums) {
        int xor = 0;

        for(int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = { 2,2, 1 };
        System.out.println(OptSingleNumber(nums));
        
    }
}
