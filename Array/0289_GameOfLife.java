// https://leetcode.com/problems/game-of-life/
// the below solutions is stil O(mn) space. It can be improved to O(1) by using 2 bits to store 2 different states of each position (current and next stage). 
// using 2 bits helps retained the original state of each position and facilitate the appending of the next state in the 2nd bit
class Solution {
    public void gameOfLife(int[][] board) {
        int[][] sim = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sim[i][j] = neighbor(board, i, j);
                if (board[i][j] == 0) {
                    if (sim[i][j] == 3) sim[i][j] = 1;
                    else sim[i][j] = 0;
                }
                else {
                    if (sim[i][j] < 2) {
                        sim[i][j] = 0;
                    }
                    else if (sim[i][j] == 2 || sim[i][j] == 3) {
                        sim[i][j] = 1;
                    }
                    else {
                        sim[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = sim[i][j];
            }
        }
    }
    
    public int neighbor(int[][] board, int i, int j) {
        int pi = (i == 0) ? -1 : i-1;
        int ni = (i == board.length - 1) ? -1 : i + 1;
        int pj = (j == 0) ? -1 : j-1;
        int nj = (j == board[0].length - 1) ? -1 : j + 1;
        
        return value(board, pi, j) + value(board, ni, j) + value(board, i, nj) + value(board, i, pj) + value(board, pi, pj) + value(board, pi, nj) + value(board, ni, nj) + value(board, ni, pj);
        
    } 
    
    public int value(int[][] board, int i, int j) {
        if (i == -1 || j == -1) return 0;
        return board[i][j];
    }
}
