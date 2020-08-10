//https://leetcode.com/problems/minimum-path-sum/

class Solution {
    public int minPathSum(int[][] grid) {
        // min[g[m-1][n-1] = min (g[m-2][n-1], g[m-1][n-2]) + g[m-1][n-1]
        // int[][] dp = new int[grid.length][grid[0].length];
        // dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i==0 && j == 0) continue;
                if (i == 0) {
                    grid[i][j] += grid[i][j-1];
                }
                else if (j == 0) {
                    grid[i][j] += grid[i-1][j];
                }
                else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
                // System.out.println("g[" + i + "," + j + "]= " + grid[i][j]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}