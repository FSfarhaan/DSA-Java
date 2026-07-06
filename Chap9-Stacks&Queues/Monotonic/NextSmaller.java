import java.util.Stack;

public class NextSmaller {

    // Brute force (TC -> n2, SC -> 1);
    static int[] getSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
            if(ans[i] == 0) ans[i] = -1;
        }

        return ans;
    }

    // Optimal approach
    static int[] OptGetSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();

            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();

            stack.push(arr[i]);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = { 4, 8, 5, 2, 25 };

        int[] ans = OptGetSmaller(arr);

        for(int k : ans) {
            System.out.print(k + " ");
        }
    }
}
