public class NextGreater2 {

    // Brute force
    static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            int j = i + 1;
            while (i != j) {
                if(nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
                j = (j + 1) % n;
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        int[] nums = {1,2,1};

        int[] ans = nextGreaterElements(nums);

        for(int k: ans) {
            System.out.print(k + " ");
        }        
    }
}
