public class PeakElement {

    // Brute force (TC -> n*m, SC -> 1); => Going through all the elements



    static int getHighest(int matrix[][], int mid, int n) {
        int max = -1;
        int index = -1;
        for(int i = 0; i < n; i++) {
            if(matrix[i][mid] > max) {
                max = matrix[i][mid];
                index = i;
            }
        }
        return index;
    }

    // Optimal Approach
    static int[] getIndexes(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int highestIndex = getHighest(matrix, mid, n);

            int left = mid > 0 ? matrix[highestIndex][mid - 1] : -1;
            int right = mid < (m - 1) ? matrix[highestIndex][mid + 1] : -1;

            int element = matrix[highestIndex][mid];
            if(element > left && element > right) {
                return new int[] { highestIndex, mid };
            } else if(element < left) {
                high = mid - 1;
            } else low = mid + 1;
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int matrix[][] =  { {1, 2, 3}, {6, 5, 4}, {7, 8, 9}};
        int ans[] = getIndexes(matrix);
        System.out.println("The answer is: " + ans[0] + " and " + ans[1]);
    }    
}
