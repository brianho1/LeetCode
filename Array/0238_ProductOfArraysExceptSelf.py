# https://leetcode.com/problems/product-of-array-except-self
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
#         length = len(nums)
#         L , R, res = [1] * length , [1] * length, [1] * length
#         for i in range(1, len(nums)):
#             L[i] = L[i-1] * nums[i-1]
            
#         for i in reversed(range(length-1)):
#             R[i] = R[i+1] * nums[i+1]
            
#         for i in range(length):
#             res[i] = L[i] * R[i]
            
#         return res

        length = len(nums)
        res = [1] * length
        for i in range(1, len(nums)): # calculate the product to the left of index i
            res[i] = res[i-1] * nums[i-1]
        R = 1
        for i in reversed(range(length)): # multiplying the product to the right of index i
            res[i] = res[i] * R
            R *= nums[i]
            
        return res