import java.util.Stack;

public class SubarrayMinimums {

    // Brute force (TC -> n2, SC -> 1) 
    static int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int MOD = (int)1e9 + 7;

        for(int i = 0; i < n; i++) {
            int min = arr[i];
            for(int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % MOD;
            }
        }
        return sum;
    }



    static int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();

            if(stack.isEmpty()) ans[i] = n;
            else ans[i] = stack.peek();

            stack.push(i);
        }

        return ans;
    }

    static int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();

            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();

            stack.push(i);
        }

        return ans;
    }


    // Optimal approach
    static int OptSumSubarrayMins(int[] arr) {
        int[] NSE = findNSE(arr);
        int[] PSEE = findPSEE(arr);
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
        int[] arr = { 11,81,94,43,3 };
        System.out.println(OptSumSubarrayMins(arr));
    }
}
