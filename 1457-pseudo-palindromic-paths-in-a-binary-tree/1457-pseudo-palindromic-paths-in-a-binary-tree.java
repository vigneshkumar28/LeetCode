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
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, 0);
        return count;
    }
    private void dfs(TreeNode node, int isThere){
        if(node == null)
            return;
        isThere = isThere ^ (1<<node.val);
        if(node.left==null && node.right==null){
            if((isThere & (isThere-1)) == 0)
                count++;
        }
        dfs(node.right, isThere);
        dfs(node.left, isThere);
    }
}