// https://leetcode.com/problems/perfect-squares/

class Solution {
    public int numSquares(int n) {
        // 12 = 3
        
        // F(1) = 1
        // F(2) = F(1) + F(2-1) = 2
        // F(3) = F(2) + F(3-2) = 3
        // F(4) = (4 - 4 = 0) = 1
        // F(5) = 2^2 + F(5-4) = 2
        // F(6) = 2^2 + F(2) = 3
        // F(10) = 3^2 + F(10-3^2)
        // F(11) = (4 + 4 + 3 OR 9 + 2) = 3
        // F(12) = 3^2 (9) + F(12-9 = 3) = 4
        // F(12) = 2^2 + F(12-2^2)
        // F(13) = 3^3 + F(13-9 = 4)
        // F(14) = 3^3 + F(5)
        // F(15) = 3^3 + F(6) = 4
        // F(15) = 4 + F(11)
        // F(265) = 16^2 + F(9) = 2
        // F(87) = 9^2 + F(6) = 4
        // F(87) = 8^2 + F(23) = 8^2 + 4^2 + 4 = 6
        // F(87) = 7^2 + F(38)  = 4
        // F(237) = 15^2 + F12 = 4
        // 14^2 + 6^2 + F(5) = 4
        // 2^2 + 8^2 + 13^2 = 
        int[] dp = new int[n];
        dp[0] = 1;// F(1) = 1
        dp[1] = 2;// F(2) = 2
        dp[2] = 3;
        if (n <= 3) return dp[n-1];
        // double sr = Math.sqrt(n);
        // if (sr - Math.floor(sr) == 0) return 1;
        
        for (int i = 3; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i + 1; j++) {
                if ( i + 1 == j * j) {
                    min = 1;
                    break;
                }
                min = Math.min(min, dp[i - j*j] + 1); // 3 - 1*1 - 1 = dp[1]
            }
            dp[i] = min;
            // System.out.print(dp[i] + " ");
        }
        return dp[n-1];
    }
}