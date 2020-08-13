# https://leetcode.com/problems/counting-bits/
class Solution:
    def countBits(self, num: int) -> List[int]:
        
        res = [0] * (num + 1)
        for i in range(1, num+1):
            if (i & 1 == 0): # if i is even then i has the same bits as i / 2
                res[i] = res[i >> 1] 
            else:
                res[i] = res[i - 1] + 1
        return res
                
            