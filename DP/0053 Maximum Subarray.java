class Solution {
    public int maxSubArray(int[] nums) {
        int[] maxArray = new int[nums.length];
        maxArray[0] = nums[0];
        int max = maxArray[0];
        for (int i = 1; i < nums.length; i++) {
            maxArray[i] = (maxArray[i-1] > 0 ? maxArray[i-1] : 0) + nums[i];
            max = Math.max(max, maxArray[i]);
        }
        return max;
    }
}