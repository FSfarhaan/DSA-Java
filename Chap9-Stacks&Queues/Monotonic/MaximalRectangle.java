import java.util.Stack;

public class MaximalRectangle {

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

    static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        
        int[][] prefixSum = new int[n][m];

        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                if(matrix[j][i] == '1') {
                    prefixSum[j][i] = ++sum;
                } else {
                    prefixSum[j][i] = 0;
                    sum = 0;
                }
            }
        }

        for(int[] row: prefixSum) {
            maxArea = Math.max(maxArea, OptLargestRectangleArea(row));
        }

        return maxArea;
    }
    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','1','1'},
            {'0','1','0','1','0'},
            {'1','1','0','1','1'},
            {'1','1','0','1','1'},
            {'0','1','1','1','1'},
        };
        
        System.out.println(maximalRectangle(matrix));
    }
}
