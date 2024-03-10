/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 * Problem ID: 513. Find Bottom Left Tree Value
 *
 * Author: Ateto
 *
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
    private int leftmost;
    private int maxHeight;

    private void dfs(TreeNode root, int depth) {
        if(root == null) return ;
        if(root.left == null && root.right == null) {
            if(depth > this.maxHeight) {
                this.maxHeight = depth;
                this.leftmost = root.val;
            }
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        this.leftmost = root.val;
        this.maxHeight = 0;
        dfs(root, 0);
        return this.leftmost;
    }
}