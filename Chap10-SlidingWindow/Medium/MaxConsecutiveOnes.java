public class MaxConsecutiveOnes {

    // Brute force (TC -> n2, SC -> 1);
    static int longestOnes(int[] nums, int k) {
        int max = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int zeros = 0;
            for(int j = i; j < n; j++) {
                if(nums[j] == 0) zeros++;
                if(zeros > k) {
                    int len = j - i;
                    max = Math.max(max, len);
                    break;
                }
            }
            if(zeros <= k) max = Math.max(max, n - i);
        }

        return max;
    }

    // Better approach (TC -> 2n, SC -> 1);
    static int BetLongestOnes(int[] nums, int k) {
        int max = 0, n = nums.length;
        int left = 0, right = 0;
        int zeros = 0;

        while (right < n) {
            if(nums[right] == 0) zeros++;

            if(zeros > k) {
                
                while (zeros > k) {       
                    if(nums[left] == 0) zeros--;
                    left++;
                }
            }

            int len = right - left + 1;
            max = Math.max(max, len);

            right++;
        }

        return max;
    }

    // Optimal approach (TC -> n, SC -> 1);
    static int OptLongestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int left = 0, right = 0;
        int zeros = 0;

        while (right < n) {
            if(nums[right] == 0) zeros++;

            if(zeros > k) {
                if(nums[left] == 0) {
                    zeros--;
                }
                
                left++;
            }

            int len = right - left + 1;
            max = Math.max(max, len);

            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        
        int k = 2;

        System.out.println(BetLongestOnes(arr, k));
    }
}
