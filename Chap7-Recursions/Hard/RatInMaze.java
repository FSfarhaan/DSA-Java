import java.util.ArrayList;

public class RatInMaze {

    static void solve(int[][] maze, int row, int col, String ds, ArrayList<String> ans, int n, int m) {
        if(row == n - 1 && col == m - 1) {
            ans.add(new String(ds));
            return;
        }

        if(maze[row][col] == 1) {
            // Search next for DLRU way, because it follow lexicographically smallest order
            
            // DLRU
            // row: +1 +0 +0 -1
            // col: +0 -1 +1 +0
            int[] dr = { 1, 0, 0, -1};
            int[] dc = { 0, -1, 1, 0};
            String dir = "DLRU";
            
            for(int i = 0; i < 4; i++) {
                int ansR = row + dr[i];
                int ansC = col + dc[i];
                if(ansR >= 0 && ansR < n && ansC >= 0 && ansC < m && maze[ansR][ansC] != -1) {
                    // System.out.println("Andar ghusa kya? Direction hai " + row + " " + col + " " + dir.charAt(i));
                    maze[row][col] = -1;
                    solve(maze, ansR, ansC, ds+ dir.charAt(i), ans, n, m);
                    maze[row][col] = 1;    
                }
            }

            // // Search down
            // if(row+1 < n && maze[row+1][col] != -1){
            //     maze[row][col] = -1;
            //     solve(maze, row+1, col, ds+ "D", ans, n, m);
            //     maze[row][col] = 1;
            // }
            

            // // Search left
            // if(col-1 >= 0 && maze[row][col-1] != -1) {
            //     maze[row][col] = -1;
            //     solve(maze, row, col-1, ds + "L", ans, n, m);
            //     maze[row][col] = 1;
            // }

            // // Search right 
            // if(col+1 < m && maze[row][col+1] != -1) {
            //     maze[row][col] = -1;
            //     solve(maze, row, col+1, ds + "R", ans, n, m);
            //     maze[row][col] = 1;
            // }

            // // Search up
            // if(row-1 >= 0 && maze[row-1][col] != -1) {
            //     maze[row][col] = -1;
            //     solve(maze, row-1, col, ds + "U", ans, n, m);
            //     maze[row][col] = 1;
            // }
        }
    }

    static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans = new ArrayList<>();
        if(maze[0][0] != 1) return ans;

        solve(maze, 0, 0, "", ans, maze.length, maze[0].length);
        return ans;
    }
    public static void main(String[] args) {
        int maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        ArrayList<String> ans = ratInMaze(maze);
        

        for(String s: ans) {
            System.out.println(s);
        }
    }
}
