class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        for (int i = 1; i <= (x+1)/2 ; i++) {
            if (i * i > x) {
                return i-1;
            }
            
        }
        return 0;
    }
}