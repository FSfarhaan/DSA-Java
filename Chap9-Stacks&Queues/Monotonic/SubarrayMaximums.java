import java.util.Stack;

public class SubarrayMaximums {

    static int subarrayMaximums(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int MOD = (int)1e9 + 7;
    
        for(int i = 0; i < n; i++) {
            int max = arr[i];
            for(int j = i; j < n; j++) {
                max = Math.max(max, arr[j]);
                sum = (sum + max) % MOD;
            }
        }
        return sum;
    }

    static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop();

            if(stack.isEmpty()) ans[i] = n;
            else ans[i] = stack.peek();

            stack.push(i);
        }
        return ans;
    }
    
    static int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop();

            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();

            stack.push(i);
        }
        return ans;
    }

    // Optimal approach
    static int OptSumSubarrayMaxs(int[] arr) {
        int[] NSE = findNGE(arr);
        int[] PSEE = findPGE(arr);
        int MOD = (int)1e9 + 7;
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            int left = i - PSEE[i];
            int right = NSE[i] - i; 

            long freq = left * right * 1L;
            int val = (int) ((freq * arr[i]) % MOD);

            sum = (sum + val) % MOD;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 0, 5, 2, 25};
        System.out.println(OptSumSubarrayMaxs(arr));

    //     int[] ans = findPGE(arr);

    //     for(int k: ans) {
    //         System.out.print(k + " ");
    //     }
    }
}
