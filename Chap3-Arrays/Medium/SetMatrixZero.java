public class SetMatrixZero {

    static void markRow(int arr[][], int i, int m) {
        for(int j = 0; j < m; j++) {
            if(arr[i][j] != 0) arr[i][j] = -1;
        }
    }

    static void markCol(int arr[][], int j, int n) {
        for(int i = 0; i < n; i++) {
            if(arr[i][j] != 0) arr[i][j] = -1;
        }
    }


    // Brute force (TC -> N*M (N + M) + ( N*M), SC -> 1)
    static void setZero(int arr[][]) {
        
        int n = arr.length; // rows
        int m = arr[0].length; // Columns
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
                    markRow(arr, i, m);
                    markCol(arr, j, n);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < n; i++ ) {
            for(int j = 0; j < m; j++ ) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    // Better Approach (TC -> 2n*m, SC-> n + m );
    static void BetSetZero(int arr[][]) {
        int n = arr.length; // Rows
        int m = arr[0].length; // Cols

        int rowArr[] = new int[n];
        int colArr[] = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                   rowArr[i] = 1;
                   colArr[j] = 1; 
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(rowArr[i] == 1 || colArr[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < n; i++ ) {
            for(int j = 0; j < m; j++ ) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Optimal Approach (TC -> 2N*M, SC -> 1)
    static void OptSetMatrix(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int col0 = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    // Mark row
                    arr[i][0] = 0;
                    // Mark Col
                    if(j != 0) arr[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if(arr[0][0] == 0) {
            for(int j = 0; j < m; j++) {
                arr[0][j] = 0;
            }
        }   

        if(col0 == 0) {
            for(int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }

        for(int i = 0; i < n; i++ ) {
            for(int j = 0; j < m; j++ ) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        int arr[][] = {{1,1,1},{1,0,1},{1,1,1}};
        // setZero(arr);
        // BetSetZero(arr);
        OptSetMatrix(arr);
    }
}
