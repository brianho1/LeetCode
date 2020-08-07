//https://leetcode.com/problems/find-all-duplicates-in-an-array/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (nums[Math.abs(index) - 1] > 0) {
                nums[Math.abs(index)-1] = -nums[Math.abs(index)-1];
            }
            else {
                res.add(Math.abs(nums[i]));
            }
        }
        return res;
    }
}