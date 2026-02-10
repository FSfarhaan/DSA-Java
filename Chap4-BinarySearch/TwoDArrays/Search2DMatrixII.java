public class Search2DMatrixII {
    // Brute Force Loop through all the element, check them. If matches, return;
    //  (TC -> n*m , SC -> 1); Not doing, as it is same as Search2DMatrix


    // Better Approach. Loop through the columns and as the rows are sorted, apply BS to find the elements
    // (TC -> n * logm, SC ->);


    // Optimal Approach,
    // 1   4   7   11
    // 2   5   8   12
    // 3   6   9   16
    // 10 13  14  17
    // Intution. I will start at top right or bottom left. The thing is, if the top right is bigger than my target, then as the column is sorted, all the numbers below it cannot be my target. So i will trim that column and move to left. If that is lesser than my target, so as the rows are sorted, all the numbers before it will also be below the target and hence i will not my target there. So I will trim down that row and go to the below row. Same thing is repeated.
    // (TC -> n + m, SC -> 1)
    static int[] findIndex(int matrix[][], int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m-1;
        while (row < n && col >= 0) {
            int element = matrix[row][col];
            if(element == target) return new int[] {row, col};
            else if(element > target) col--;
            else row++;
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int matrix[][] = {{ 1,   4,   7,   11}, {2,   5,   8,   12}, {3,   6,   9,   16}, { 10, 13,  14,  17}, {18, 21, 23, 26, 30}};
        int target = 16;
        int ans[] = findIndex(matrix, target);
        System.out.println("The element is as at: " + ans[0] + " and " + ans[1]);

    }
}
