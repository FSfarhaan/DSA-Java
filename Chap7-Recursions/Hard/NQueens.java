import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    static boolean isSafeToPlace(char board[][], int row, int col, int n) {
        // Check for left
        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i] == 'Q') return false;
        }  

        // Check for top left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        // Check for down left diagonal
        for(int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
    
    static void solve(char board[][], int col, int n, List<List<String>> ans) {
        if(col == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int row = 0; row < n; row++) {
            if(isSafeToPlace(board, row, col, n)) {
                board[row][col] = 'Q';

                // Go to next col
                solve(board, col+1, n, ans);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    static void solve2(char board[][], int col, int n, List<List<String>> ans, int left[], int topLDiagonal[], int bottomLDiagonal[]) {
        if(col == n) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int row = 0; row < n; row++) {
            // Check for left
            if(left[row] == 0 && topLDiagonal[row + col] == 0 && bottomLDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                left[row] = 1;
                topLDiagonal[row + col] = 1;
                bottomLDiagonal[n - 1 + col - row] = 1;

                solve2(board, col+1, n, ans, left, topLDiagonal, bottomLDiagonal);

                board[row][col] = '.';
                left[row] = 0;
                topLDiagonal[row + col] = 0;
                bottomLDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    // Approach 1 (TC -> n! * n, SC -> n2 + n);
    static List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        solve(board, 0, n, ans);
        return ans;
    }
    
    // Approach 1 (TC -> n!, SC -> n);
    static List<List<String>> solveNQueens2(int n) {
        char board[][] = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        int leftRow[] = new int[n];
        int topLDiagonal[] = new int[2*n - 1];
        int bottomLDiagonal[] = new int[2*n - 1];

        solve2(board, 0, n, ans, leftRow, topLDiagonal, bottomLDiagonal);
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = solveNQueens2(n);
        for(List<String> list: ans)  {
            for(String str: list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }   
}
