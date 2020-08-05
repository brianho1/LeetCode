//https://leetcode.com/problems/power-of-four/submissions/

class Solution {
    public boolean isPowerOfFour(int num) {
		// if (num == 0) return false;
		// double i = Math.log(num) / Math.log(4);
		// return i == Math.floor(i);
        
        if ((num == 0) || (num&(num-1)) != 0) {
            return false;
        }
        return (num -1) % 3 == 0;
    }
}