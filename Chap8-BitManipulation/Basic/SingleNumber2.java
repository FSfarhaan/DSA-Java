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

    // Bit approach (TC -> 32n, SC -> 1);
    static int BitSingle(int[] nums) {
        int ans = 0;
        for(int bit = 0; bit < 32; bit++) {
            int ones = 0;
            for(int i = 0; i < nums.length; i++) {
                if((nums[i] & (1 << bit)) != 0) ones++;
            }
            if(ones % 3 != 0) ans = ans | (1 << bit);
        }
        return ans;
    }

    // Better approach (TC -> nlogn + n/3, SC -> 1) 
    // (Log n will never reach 32, because it has to be 2^32, thats why this is better than the above one)
    static int BetSingleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i += 3) {
            if(nums[i] != nums[i-1]) return nums[i-1];
        }
        return nums[nums.length - 1];
    }

    // Optimal - Bucket approach (TC -> n, SC - > 1);
    static int BucketSingle(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] nums = { 0,1,0,1,0,1,99 };
        // 4 -> 1 0 0 & 1 << 2
        System.out.println(BitSingle(nums));
    }
}
