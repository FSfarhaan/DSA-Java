import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {

    // Brute force (TC -> nlogn + n/3 + 1, SC -> n/3 + 1);
    static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) return entry.getKey();
        }

        return 0;
    }

    // Better approach
    static int BetSingleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i += 3) {
            if(nums[i] != nums[i-1]) return nums[i-1];
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 0,1,0,1,0,1,99 };
        System.out.println(BetSingleNumber(nums));
    }
}
