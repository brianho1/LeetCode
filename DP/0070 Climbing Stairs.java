class Solution {
    public int climbStairs(int n) {
        int[] df = new int[n+1];
        if (n == 1 || n == 2) {
            return n;
        }
//         df[1] = 1;
//         df[2] = 2;
//         for (int i = 3; i <=n; i ++) {
//             df[i] = df[i-1] + df[i-2];
//         }
        
//         return df[n];
        
        int first = 1;
        int second = 2;
        for (int i = 3; i <=n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}