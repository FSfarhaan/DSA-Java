import java.util.Stack;

public class SubarrayRanges {

    static int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    static int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    static long OptSumSubarrayMins(int[] arr) {
        int[] NSE = findNSE(arr);
        int[] PSEE = findPSEE(arr);

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - PSEE[i];
            long right = NSE[i] - i;

            sum += left * right * arr[i];
        }

        return sum;
    }

    static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    static int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    static long OptSumSubarrayMaxs(int[] arr) {
        int[] NGE = findNGE(arr);
        int[] PGEE = findPGEE(arr);

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - PGEE[i];
            long right = NGE[i] - i;

            sum += left * right * arr[i];
        }

        return sum;
    }

    static long subArrayRanges(int[] arr) {
        return OptSumSubarrayMaxs(arr) - OptSumSubarrayMins(arr);
    }

    public static void main(String[] args) {
        int[] arr = {4, -2, -3, 4, 1};
        System.out.println(subArrayRanges(arr));
    }
}