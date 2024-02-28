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
    int maxDepth = -1;
    int leftNode = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return leftNode;
    }
    public void dfs(TreeNode root, int depth){
        if(root == null)
            return;
        if(depth > maxDepth){
            maxDepth = depth;
            leftNode = root.val;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}