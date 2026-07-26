public class NiceSubarrays {

    // Brute force (TC - n2, SC -> 1);
    static int numberOfSubarrays(int[] nums, int goal) {
        int count = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            int sum = 0;

            for(int j = i; j < n; j++) {
                sum += nums[j] % 2;
                if(sum == goal) count++;
            }
        }

        return count;
    }

    // Better 
    static int BetSubarrrayWithSum(int[] nums, int goal) {
        if(goal == -1) return 0;
        int n = nums.length;
        int l = 0, r = 0;
        int sum = 0, count = 0;

        while (r < n) {
            sum += nums[r] % 2;

            while (sum > goal) {
                sum -= nums[l] % 2;
                l++;
            }

            count += (r - l + 1);
            r++;
        }
        
        return count;
    }

    static int helper(int[] arr, int goal) {
        int n1 = BetSubarrrayWithSum(arr, goal);
        int n2 = BetSubarrrayWithSum(arr, goal - 1);
        System.out.println(n1);
        System.out.println(n2);

        return n1 - n2;
    }

    public static void main(String[] args) {
        int[] arr = { 2,4,6 };
        int k = 1;
        
        // System.out.println(numberOfSubarrays(arr, k));
        System.out.println(helper(arr, k));
    }
}
