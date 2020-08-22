# https://leetcode.com/problems/balanced-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

#     this solution is O(nlogn)
#     def isBalanced(self, root: TreeNode) -> bool:
#         if not root:
#             return True
#         lh = self.height(root.left)
#         rh = self.height(root.right)
#         return abs(lh- rh) <= 1 and self.isBalanced(root.left) and self.isBalanced(root.right)
        
#     def height(self, node: TreeNode) -> int:
#         if not node:
#             return 0
        
#         return max(self.height(node.left), self.height(node.right)) + 1

# O(n) solution
    def isBalanced(self, root: TreeNode) -> bool:
        return self.dfs(root)[0]
    
    def dfs(self, root:TreeNode) -> (bool, int):
        if not root:
            return True, -1
        
        l = self.dfs(root.left)
        r = self.dfs(root.right)
        
        return (l[0] and r[0] and abs(l[1] - r[1]) <= 1 , max(l[1],r[1]) + 1)