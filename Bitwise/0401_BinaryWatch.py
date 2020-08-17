# https://leetcode.com/problems/binary-watch/
class Solution:
    def readBinaryWatch(self, num: int) -> List[str]:
        list = [0] * 60
        for i in range(1, 60):
            if (i & 1 == 0): # if i is even then i has the same bits as i / 2
                list[i] = list[i >> 1] 
            else:
                list[i] = list[i - 1] + 1
        res = []

        for h in range(12):
            for m in range(60):
                if list[h] + list[m] == num:
                    res.append('%d:%02d' % (h, m))    

        return res
