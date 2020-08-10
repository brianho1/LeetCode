//https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // s[i] = Min(s[i-1], s[i-2]) + c[i]
        
        // result = Min (s[n-1]), s[n-2])
        // s[n-1] = Min(s[n-2], s[n-3]) + c[n-1]
        // s[n-2] = min(s[n-3], s[n-4]) + c[n-2]
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        int dp0 = cost[0];
        int dp1 = cost[1];
        int res = 0;
        for (int i = 2; i <= cost.length; i++) {
            int c = (i == cost.length) ? 0 : cost[i];
            res = Math.min(dp1, dp0) + c;
            // System.out.println("d[" + i + "]= " + res);
            dp0 = dp1;
            dp1 = res;
        }
        return res;
    }
}