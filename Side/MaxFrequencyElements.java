import java.util.HashMap;

public class MaxFrequencyElements {
    // Brute force (TC -> 3nlogn, Sc -> n);
    static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int max = 0;
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
            int val = map.getOrDefault(nums[i], 0) + 1;
            max = Math.max(max, val);
            map.put(nums[i], val);
        }

        for(int i = 0; i < n; i++) {
            if(map.get(nums[i]) == max) sum++;
        }

        return sum;
    }

    // Optimal approach (TC -> 3n, SC -> 101);
    static int maxFrequency(int nums[]) {
        int freq[] = new int[101];

        for(int i: nums) {
            freq[i]++;
        }

        int max = 0;
        for(int j: freq) {
            if(j > max) max = j;
        }

        int total = 0;
        for(int k: freq) {
            if(k == max) total += k;
        }

        return total;

    }
    public static void main(String[] args) {
        int nums[] = { 1,2,3,4,5 };
        System.out.println(maxFrequency(nums));
    }
}
