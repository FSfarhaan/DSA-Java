public class Maximum1s {

    // Brute force (TC -> n * m, SC -> 1);
    static int getMax1s(int matrix[][], int n, int m) {
        int countMax = 0;
        int index = -1;

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < m; j++) {
                count += matrix[i][j];
                if(count > countMax) {
                    countMax = count;
                    index = i;
                }
            }
        }

        return index;
    }

    static int getLowerBound(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= target) {
                high = mid - 1;
            } else low = mid + 1;
        }

        return low;
    }

    // Optimal Approach (TC -> n * logm, SC -> 1);
    static int OptGetMax1s (int matrix[][], int n, int m) {
        int countMax = 0;
        int index = -1;

        for(int i = 0; i < n; i++) {
            int indexOfOne = getLowerBound(matrix[i], 1);
            System.out.println("Index ye mili hai first " + indexOfOne);
            int numsOfOne = m - indexOfOne;

            if(numsOfOne > countMax) {
                countMax = numsOfOne;
                index = i;
            }
            
        }

        return index;
    }
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1}, {0, 1, 1}, {0, 1, 1}};
        int n = 3, m = 3;
        // System.out.println("The row with maximum 1s is: " + getMax1s(matrix, n, m));
        System.out.println("The row with maximum 1s is: " + OptGetMax1s(matrix, n, m));
    }
}
