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
    int maximum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        recur(root);
        return maximum;
    }
    private int recur(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh = recur(root.left);
        int rh = recur(root.right);
        maximum = Math.max(maximum, lh+rh);
        return 1 + Math.max(lh,rh);
    }
}
