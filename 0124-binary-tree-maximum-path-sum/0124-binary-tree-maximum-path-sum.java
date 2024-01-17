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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathHelper(root);
        return maxPath;
    }
    private int maxPathHelper(TreeNode root){
         if(root == null)
            return 0;
        int leftMax = Math.max(0, maxPathHelper(root.left));
        int rightMax = Math.max(0, maxPathHelper(root.right));
        maxPath = Math.max(maxPath, leftMax+rightMax+root.val);
        return Math.max(leftMax, rightMax)+root.val;
    }
}