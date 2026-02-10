import java.util.Arrays;

public class MatrixMedian {

    // Brute force (TC -> n*m + n*mlog(m*n), SC -> n*m);
    static int getMedian(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        int ans[] = new int[n*m];
        int top = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans[top++] = matrix[i][j];
            }
        }
        Arrays.sort(ans);
        return ans[ans.length / 2];
    }

    static int getCounts(int arr[], int ele) {
        int low = 0, high = arr.length - 1;
        // 0 -> 2
        while (low <= high) {
            int mid = low + (high - low )/ 2;
            if(arr[mid] <= ele) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }

    // Optimal Approach
    static int OptGetMedian(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = matrix[0][m-1];
        int reqInd = (n * m - 1) / 2;

        for(int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m -1]);
        }

        while (low <= high) {
            int count = 0;
            int mid = low + (high - low) / 2;
            
            for(int i = 0; i < n; i++) {
                count += getCounts(matrix[i], mid);
            }

            if(count <= reqInd) low = mid + 1;
            else high = mid - 1;
        }

        return low;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        // 1, 1, 2, 2, 3, 3, 4, 5, 8
        // System.out.println("The median is: " + getMedian(matrix));
        System.out.println("The median is: " + OptGetMedian(matrix));
        // System.out.println("The median is: " + getCounts(matrix[1], 4));

    }
}
