import java.util.HashMap;
import java.util.Stack;

public class NextGreater2 {

    // Brute force (TC -> n2, SC -> n);
    static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            while (i != j) {
                if(nums[j] > nums[i]) {
                    ans[i] = nums[j] == 0 ? Integer.MAX_VALUE : nums[j];
                    break;
                }
                j = (j + 1) % n;
            }
        }

        for(int i = 0; i < n; i++) {
            if(ans[i] == 0) ans[i] = -1;
            if(ans[i] == Integer.MAX_VALUE) ans[i] = 0;
        }

        return ans;
    }


    // Optimal approach
    static int[] OptNextGreaterElements(int[] nums) {
        int n = nums.length;
        
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 2*n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            if(i < n) {
                ans[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(nums[i % n]);

        }

        return ans;

    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};

        int[] ans = OptNextGreaterElements(nums);

        for(int k: ans) {
            System.out.print(k + " ");
        }        
    }
}
