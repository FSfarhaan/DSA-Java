public class Search2DMatrix {

    // Brute force (TC -> n*m, SC -> 1);
    static int[] findElement(int matrix[][], int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int binarySearch(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= target) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return low;
    }

    // Better approach (TC -> n + logm, SC -> 1);
    static int[] BetFindElement(int matrix[][], int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++) {
            if(matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                int j = binarySearch(matrix[i], target);
                return new int[] { i, j };
            }
        }

        return new int[] {-1, -1};
    }

    // Optimal Approach (TC -> logn, SC -> 1);
    static int[] OptGetElement(int matrix[][], int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] == target) {
                return new int[] { row, col };
            }
            else if(matrix[row][col] > target) {
                high = mid - 1;
            } else low = mid + 1;
        }
        
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 7;
        // int ans[] = findElement(matrix, target);
        // int ans[] = BetFindElement(matrix, target);
        int ans[] = OptGetElement(matrix, target);
        System.out.println("IS the element present ? " + ans[0] + " and " + ans[1]);
    }
}
