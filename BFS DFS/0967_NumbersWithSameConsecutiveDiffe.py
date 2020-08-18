# 967. Numbers With Same Consecutive Differences
# https://leetcode.com/problems/numbers-with-same-consecutive-differences/

class Solution:
    def numsSameConsecDiff(self, N: int, K: int) -> List[int]:
        res = []
        if N <= 1: res.append(0)
        for i in range(10):
            self.helper(i, N-1, res, K)
        
        return res
    
    def helper(self, num: int, rem: int, res:List[int], K:int):
        if num == 0:
            return
        if rem == 0:
            res.append(num)
            return

        if num % 10 - K in range(10):
            self.helper(num * 10 + num % 10 - K, rem - 1, res, K)
        if K!= 0 and num % 10 + K in range(10):
            self.helper(num * 10 + num % 10 + K, rem - 1, res, K)
