# https://leetcode.com/problems/k-closest-points-to-origin
class Solution:
    def kClosest(self, points: List[List[int]], K: int) -> List[List[int]]:
        
        heap = [(point[0] ** 2 + point[1] ** 2, point) for point in points]
        heapq.heapify(heap)
        
        return [heapq.heappop(heap)[1] for _ in range(K)]
    
        