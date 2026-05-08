import java.util.HashMap;
import java.util.Map;

public class SingleNumber3 {

    // Brute force
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
    public static void main(String[] args) {
        int[] nums = { 1,2,1,3,2,5 };
        int[] ans = singleNumber(nums);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
