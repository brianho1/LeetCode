 # https://leetcode.com/problems/trapping-rain-water

class Solution:
    def trap(self, height: List[int]) -> int:
        '''
        brute force:
        count 0 water between walls of minimum 1's and minus 1 from the arrays next round
        too slow
        '''
#         water = 0
#         n = len(height)
#         t = False
#         notsure = 0
#         i = 0
#         allzero = True
#         r = 0
#         while i < n:
#             if height[i] > 0 and r > 0: height[i] -= 1
#             if height[i] >= 1:
#                 t = True
#                 allzero = False
#             if t and height[i] == 0:
#                 water += 1
#                 notsure += 1
#                 if i < n -1 and height[i+1]-r > 0: t = False
#             if notsure > 0 and height[i] >= 1:
#                 notsure = 0
#             i += 1
#             if i == n and allzero == True:
#                 break
#             if i == n:
#                 water -= notsure
#                 t = False
#                 allzero = True
#                 i = 0
#                 if r == 0: r += 1
            
#         return water
        
        '''
        find the shade zones if you was to fashing a light from left to right and right to left
        the intesection of the 2 shade areas is the result
        '''

        res = 0
        n = len(height)
        if height == None or n == 0 : return 0
        

        L = [0] * n
        L[0] = height[0]
        for i in range(1, n):
            L[i] = max(height[i], L[i-1])
            
        R = [0] * n
        R[-1] = height[-1]
        for i in range(n-2, -1, -1):
            R[i] = max(height[i], R[i+1])
        
        for i in range(1, n):
            res += min(L[i],R[i]) - height[i]
        
        return res
            
            