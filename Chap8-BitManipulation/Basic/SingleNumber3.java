import java.util.HashMap;
import java.util.Map;

public class SingleNumber3 {

    // Brute force (TC -> nlogm + m, SC -> m; m = n / 3 + 1);
    static int[] singleNumber(int[] nums) {
        int[] ans = { 0, 0 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int k = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                ans[k++] = entry.getKey();
            }
        }

        return ans;
    }

    // Optimal Approach (TC -> 2n, SC -> 1);
    static int[] OptSingleNumber(int[] nums) {
        int xor = 0;
        
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }

        int rightMost = (xor & (xor - 1)) ^ xor;

        int xor1 = 0, xor2 = 0;

        for(int i = 0; i < n; i++) {
            if((nums[i] & rightMost) != 0) xor1 = xor1 ^ nums[i];
            else xor2 = xor2 ^ nums[i];
        }

        return new int[] { xor1, xor2 };
    }

    public static void main(String[] args) {
        int[] nums = { -1,0 };
        int[] ans = OptSingleNumber(nums);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
