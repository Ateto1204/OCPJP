/**
 * https://leetcode.com/problems/add-one-row-to-tree
 * Problem ID: 623. Add One Row to Tree
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
    private void solve(TreeNode node, int depth, int val, int target) {
        if (depth+1 == target && node != null) {
            TreeNode leftNode = new TreeNode(val, node.left, null);
            TreeNode rightNode = new TreeNode(val, null, node.right);
            node.left = leftNode;
            node.right = rightNode;
            return ;
        }
        if (node == null) {
            return ;
        }
        solve(node.left, depth+1, val, target);
        solve(node.right, depth+1, val, target);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode head = new TreeNode(val, root, null);
            return head;
        }
        solve(root, 1, val, depth);
        return root;
    }
}