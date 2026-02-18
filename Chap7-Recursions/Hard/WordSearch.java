public class WordSearch {
    // My solution. Failed
    static boolean backtrack(char[][] board, int row, int col, int index, String word, int prevR, int prevC) {
        System.out.println("Function chala for index of word " + index);

        if(index == word.length()) return true;
        if(col == board[0].length && row == board.length) {
            return false;
        }

        if(index == 0) {
            boolean shouldBreak = false;
            for(int i = row; i < board.length; i++) {
                for(int j = col; j < board[0].length; j++) {
                    if(board[i][j] == word.charAt(index)) {
                        row = i;
                        col = j;
                        shouldBreak = true;
                        break;
                    }
                }
                if(shouldBreak) break;
                col = 0;
            }
        }

        if(board[row][col] == word.charAt(index)) {
            System.out.println("Andar ghusa word index " + index + " and board ka letter "+ board[row][col] + " and row col " + row + " " + col);
            board[row][col] = '#';
            
            // Check the right
            if(col+1 < board[0].length) {
                System.out.println("Right me dekhne gaya for " + row + " " + (col+1) + " " + (index+1));
                if(backtrack(board, row, col+1, index+1, word, row, col)) return true;
            }

            // Check the bottom
            if(row+1 < board.length) {
                System.out.println("Neeche me dekhne gaya for " + (row+1) + " " + col + " " + (index+1));
                if(backtrack(board, row+1, col, index+1, word, row, col)) return true;
            }

            // Check the left
            if(col > 0) {
                System.out.println("Left me dekhne gaya for " + row + " " + (col-1) + " " + (index+1));
                if(backtrack(board, row, col-1, index+1, word, row, col)) return true;
            } 

            // Check the up
            if(row > 0) {
                System.out.println("Upar me dekhne gaya for " + (row-1) + " " + col + " " + (index+1));
                if(backtrack(board, row-1, col, index+1, word, row, col)) return true;
            }


            // No match from all four. Go to next element

            // Before check is it the last element
            // if(row == board.length-1 && row == board[0].length-1) return false;

            // int tryRow = row, tryCol = col;
            // col++;
            // if(col == board[0].length) {
            //     col = 0;
            //     tryCol = -1;
            //     if(row != board.length-1)row++;
            // }
            
            // // System.out.println("Yaha pe aake row, col, prevR, prevC " + row+ " " + col+ " " + tryRow+ " " + tryCol) ;
            // return backtrack(board, row, col, 0, word, tryRow, tryCol);
            // System.out.println("Yaha to pohcha kya?");

        } else {
            // System.out.println("if kyu nahi chala " + row + " " + col + " " + index + " " + board[row][col]);
        }
        return false;


    }
    
    static boolean backtrack2(char[][] board, int row, int col, int index, String word, char[][] temp) {
        if(index == word.length()) return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;

        if(board[row][col] == word.charAt(index)) {
            char hash = board[row][col];
            board[row][col] = '#';
            boolean res = 
                backtrack2(board, row, col+1, index+1, word, temp) ||
                backtrack2(board, row+1, col, index+1, word, temp) ||
                backtrack2(board, row, col-1, index+1, word, temp) ||
                backtrack2(board, row-1, col, index+1, word, temp);

            board[row][col] = hash;
            return res;
        }

        return false;
    }
    
    static boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        char [][] temp = new char[n][m];
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(board[row][col] == word.charAt(0)) {
                    if(backtrack2(board, row, col, 0, word, temp)) return true;
                    
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char [][] board = {
            { 'A','B','C','E' },
            { 'S','F','C','S' },
            { 'A','D','E','E' }
        };
        String word = "ABCCD";

        System.out.println(exist(board, word));
    }
}
