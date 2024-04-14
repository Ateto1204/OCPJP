/**
 * https://leetcode.com/problems/sum-of-left-leaves
 * Problem ID: 404. Sum of Left Leaves
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
    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        int leftSum = dfs(root.left, true);
        int rightSum = dfs(root.right, false);
        return leftSum + rightSum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int result = dfs(root, false);
        return result;
    }
}