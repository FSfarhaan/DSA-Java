import java.util.Stack;

public class LargestAreaHistogram {

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

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    // Brute force (TC -> n + 2n + 2n = 5n, SC -> 2n + 2n + 2n = 6n);
    static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] NSE = findNSE(heights);
        int[] PSEE = findPSEE(heights);

        for(int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (NSE[i] - PSEE[i] - 1));
        }
        
        return maxArea;
    }

    // Optimal solution (TC -> 2n, SC -> n);
    static int OptLargestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int element = stack.pop();
                int NSE = i;
                int PSE = stack.isEmpty() ? -1: stack.peek();
                maxArea = Math.max(maxArea, heights[element] * (NSE - PSE - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int element = stack.pop();
            int PSE = stack.isEmpty() ? -1 : stack.peek();;
            int NSE = n;
            
            maxArea = Math.max(maxArea, heights[element] * (NSE - PSE - 1));
        }
        

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = { 2,4 };
        
        int[] NSE = findNSE(arr);
        int[] PSE = findPSEE(arr);
        // int[] ans = largestRectangleArea(arr);
        
        // for(int k: NSE) {
        //     System.out.print(k + " ");
        // }
        // System.out.println();
        // for(int k: PSE) {
        //     System.out.print(k + " ");
        // }
        // System.out.println();

        // for(int k: ans) {
        //     System.out.print(k + " ");
        // }
        System.out.println(OptLargestRectangleArea(arr));
    }
}
