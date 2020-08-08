// https://leetcode.com/problems/path-sum-iii/

// brute force solution. 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }
    
    public void helper(TreeNode node, int sum, int ssf) {
        if (node == null) {
            return;
        }
        
        ssf += node.val;
        if (ssf == sum) {
            count += 1;
        }
        helper(node.left, sum, ssf);
        helper(node.right, sum, ssf);
        
    }
}