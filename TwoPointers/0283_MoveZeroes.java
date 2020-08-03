class Solution {
    public void moveZeroes(int[] nums) {
    int i = 0, j = 1;
    while (i < nums.length && j < nums.length) {
        if (nums[i] != 0) {
            i++;
            j++;
        }
        else if (nums[i] == 0 && nums[j] != 0) {
            nums[i] = nums[j];
            nums[j] = 0;
            i++;
        }
        else {
            j++;
        }
    }
        
    }
}
   // i   j
// 0 0 1 2 3
// 1 0 0 2 3