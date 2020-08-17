# https://leetcode.com/problems/3sum/

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []
        nums.sort()
        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i-1]: continue
            current = nums[i]
            left = i+1
            right =n-1
            while left < right:
                sum = current + nums[left] + nums[right]
                if sum == 0:
                    res.append([current, nums[left], nums[right]])
                    while left < right and nums[left] == nums[left+1]:
                        left += 1
                    while left < right and nums[right] == nums[right-1]:
                        right -= 1
                    left += 1
                    right -= 1
                elif sum < 0:
                    left += 1
                else:
                    right -= 1
        return res
                
# -4 -1 -1 0 1 2