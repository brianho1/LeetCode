# https://leetcode.com/problems/k-closest-points-to-origin
class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        
        def compare(n1: List[int], n2: List[int]) -> int:
            return  n1[0] ** 2 + n1[1] ** 2 - n2[0] ** 2 - n2[1] ** 2
        
        points = sorted(points,key=cmp_to_key(compare))
        
        return points[0:K]