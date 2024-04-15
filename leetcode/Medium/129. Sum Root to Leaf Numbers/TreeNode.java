/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers
 * Problem ID: 129. Sum Root to Leaf Numbers
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
    private int dfs(TreeNode node, int value) {
        if (node == null) {
            return 0;
        }
        int tmp = value*10 + node.val;
        if (node.left == null && node.right == null) {
            return tmp;
        }
        return dfs(node.left, tmp) + dfs(node.right, tmp);
    }
    public int sumNumbers(TreeNode root) {
        int result = dfs(root, 0);
        return result;
    }
}