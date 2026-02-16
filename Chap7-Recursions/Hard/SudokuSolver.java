public class SudokuSolver{
    static boolean solved = false;

    static boolean isSafe(int row, int col, char ele, char[][] board) {
        // Check for within a row
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == ele) return false;
        }

        // Check for within the col
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == ele) return false;
        }

        // Check for within a grid
        // Divide into 3x3 grids, and get the grid, the element is in
        int rowGrid = row / 3;
        int colGrid = col / 3;

        // Getting the starting index of the grid to iterate and check
        int rowStart = rowGrid * 3;
        int colStart = colGrid * 3;

        for(int i = rowStart; i < rowStart + 3; i++) {
            for(int j = colStart; j < colStart + 3; j++) {
                if(board[i][j] == ele) return false;
            }
        }

        return true;
    }

    // My approach. Partially works.
    static void backtrack(int row, int col, char[][] board) {
        if(row == 9) {
            solved = true;
            return;
        }

        if(col == 9) {
            backtrack(row+1, 0, board);
            if(solved) return;
            return;
        }

        if(board[row][col] != '.') {
            backtrack(row, col + 1, board);
            if(solved) return;
            return;
        }
        
        for(int num = 1; num <= 9; num++) {
            char ch = (char)(num + '0');

            if(isSafe(row, col, ch, board)) {
                board[row][col] = ch;

                backtrack(row, col + 1, board);

                if(solved) return; // stop further exploration

                board[row][col] = '.';
            }
        }
    }
    
    static boolean isValid(int row, int col, char ele, char board[][]) {
        // Single for loop, to check all three. Row, col, and grid;
        for(int i = 0; i < 9; i++) {
            //  Check for row
            if(board[row][i] == ele) return false;
            
            // Check for col
            if(board[i][col] == ele) return false;

            // Check for grid;
            int rowGrid = (row / 3);
            int colGrid = col / 3;
            if(board[(3* rowGrid) + (i / 3)][(3 * colGrid) + (i % 3)] == ele) return false;
        }

        return true;
    }

    static boolean solve(char[][] board) {
       for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    
                    for(char ele = '1'; ele <= '9'; ele++) {
                        if(isValid(i, j, ele, board)) {
                            board[i][j] = ele;

                            if(solve(board)) return true;
                            
                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
       }
       return true;
    }


    static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static void main(String[] args) {
        char [][] board = {
            { '5','3','.','.','7','.','.','.','.' },
            { '6','.','.','1','9','5','.','.','.' },
            { '.','9','8','.','.','.','.','6','.' },
            { '8','.','.','.','6','.','.','.','3' },
            { '4','.','.','8','.','3','.','.','1' },
            { '7','.','.','.','2','.','.','.','6' },
            { '.','6','.','.','.','.','2','8','.' },
            { '.','.','.','4','1','9','.','.','5' },
            { '.','.','.','.','8','.','.','7','9' },
        };

        solveSudoku(board);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}