public class RotateMatrix90 {


    // Brute force (TC -> n*m, SC -> n*m);
    static void rotate(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans[][] = new int[n][m];

        // (0, 0) -> (0, 2)
        // (0, 1) -> (1, 2);
        // (0, 2) -> (2, 2);

        // (1, 0) -> (0, 1);
        // (1, 1) -> (1, 1);
        // (1, 2) -> (2, 1);

        // (2, 0) -> (0, 0);
        // (2, 1) -> (1, 0);
        // (2, 2) -> (2, 0);
        System.out.println("Before rotating");

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans[j][n - i - 1] = matrix[i][j];
            }
            System.out.println();
        }

        System.out.println("After rotating");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        // matrix = ans;
    }

    static void reverseRow(int arr[]) {
        int n = arr.length;
        int start = 0, end = n - 1;
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
    }

    // Optimal Approach (TC -> 2n2, SC -> 1);
    static void OptRotate(int matrix[][]) {
        int n = matrix.length;

        System.out.println("Before rotating");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 1 2 3
        // 4 5 6
        // 7 8 9

        // Transpose of the matrix;
        // 1 4 7
        // 2 5 8
        // 3 6 9

        for(int i = 0; i < n; i++) {
            for(int j = i + 1 ; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        // Reverse the rows of the matrix;
        // 7 4 1
        // 8 5 2
        // 9 6 3
        for(int k = 0; k < n; k++) {
            reverseRow(matrix[k]);
        }

        System.out.println("After rotating");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        // rotate(matrix);
        OptRotate(matrix);
    }
}
