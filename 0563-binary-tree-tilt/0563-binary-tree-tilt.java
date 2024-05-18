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
    private int total=0;
    public int findTilt(TreeNode root) {
        total = 0;
        dfs(root);
        return total;
    }
    private int dfs(TreeNode node){
        if(node == null)
            return 0;
        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);
        total += Math.abs(leftSum - rightSum);
        return node.val+leftSum+rightSum;
    }
}