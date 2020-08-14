# https://leetcode.com/problems/container-with-most-water/submissions/
    
class Solution:
    def maxArea(self, height: List[int]) -> int:
        '''
        2 pointer pattern
        l = num[j] - num[i]
        h = min(nums[i], num[j])
        maximize l * h
        [1,8,6,2,5,4,8,3,7]
        
        '''
        
        i, j = 0, len(height) - 1 
        m = 0
        while (i < j):
            m = max(min(height[i], height[j]) * (j - i) , m)
            if (height[i] <= height[j]):
                i += 1
            else:
                j -= 1
        
        return m
    

    