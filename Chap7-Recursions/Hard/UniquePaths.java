public class UniquePaths {
    static void solve(int row, int col, int n, int m, int[] output) {
        if(row == m-1 && col == n-1) {
            output[0]++;
            return;
        }

        // Go down
        if(row+1 < m) {
            solve(row+1, col, n, m, output);
        }
        // Go right
        if(col+1 < n) {
            solve(row, col+1, n, m, output);
        }
    }
    static int uniquePaths(int m, int n) {
        int output[] = { 0 };
        solve(0, 0, n, m, output);
        return output[0];
    }
    public static void main(String[] args) {
        int n = 9, m = 51;
        System.out.println(uniquePaths(m, n));   
    }
}
