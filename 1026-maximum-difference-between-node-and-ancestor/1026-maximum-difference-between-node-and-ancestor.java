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
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return max;
    }
    private void dfs(TreeNode root, int maxAnecestor, int minAncestor){
        if(root == null){
            return;
        }
        max = Math.max(max, Math.max(Math.abs(root.val - maxAnecestor), Math.abs(root.val - minAncestor)));
        maxAnecestor = Math.max(maxAnecestor, root.val);
        minAncestor = Math.min(minAncestor, root.val);
        dfs(root.left, maxAnecestor, minAncestor);
        dfs(root.right, maxAnecestor, minAncestor);
    }
}