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
    public void dfs(TreeNode root, int val, int depth, int dp){
        if(root==null)return;
        if(depth-1==dp){
            TreeNode leftChild= new TreeNode(val);
            leftChild.left= root.left;
            root.left = leftChild;
            TreeNode rightChild= new TreeNode(val);
            rightChild.right= root.right;
            root.right = rightChild;
            return;
        }
        dfs(root.left, val, depth, dp+1);
        dfs(root.right, val, depth, dp+1);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        dfs(root, val, depth, 1);
        return root;
    }
}