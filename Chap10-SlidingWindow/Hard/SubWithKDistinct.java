import java.util.HashMap;
import java.util.HashSet;

public class SubWithKDistinct {

    // Brute force (TC -> n2, SC -> n);
    static int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j < n; j++) {
                set.add(nums[j]);

                if(set.size() == k) count++;
                else if(set.size() > k) break;
            }
        }
        return count;
    }

    // Optimal (TC -> 4n, SC -> 2n);
    static int BetSubarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);            

            while (map.size() > k) {
                System.out.println("Size of map " + map.size());
                System.out.println("Issue aaya? for l " + nums[l]);
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);

                l++;
            }

            if(map.size() <= k) count += r - l + 1;

            r++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = { 1,2,1,2,3 };
        // 1 + 2 + 3 + 4
        int k = 2;

        System.out.println(BetSubarraysWithKDistinct(arr, k) - BetSubarraysWithKDistinct(arr, k-1));
    }
}