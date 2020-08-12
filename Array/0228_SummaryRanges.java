//https://leetcode.com/problems/summary-ranges/submissions/
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            StringBuilder str = new StringBuilder(Integer.toString(nums[i]));
            // System.out.println(str);
            int count = 1;
            while (i < nums.length - 1 && nums[i+1]-nums[i] == 1) {
                i++;
                count++;
            }
            if (count > 1) {
                str.append("->");
                str.append(Integer.toString(nums[i]));
            }
            res.add(str.toString());
            i++;
        }
        return res;
    }
}