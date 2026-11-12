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
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return count;
    }
    private int recursion(TreeNode root){
        int size = 0;
        if(root==null){
            return 0;
        }
        int lh = recursion(root.left);
        int rh = recursion(root.right);
        count = Math.max(count,lh+rh);
        return 1 + Math.max(lh,rh);
    }
}
