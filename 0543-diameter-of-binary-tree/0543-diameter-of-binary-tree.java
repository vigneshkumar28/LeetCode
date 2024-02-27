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
        calculateDepth(root);
        return count;
    }
    private int calculateDepth(TreeNode root){
        if(root == null)
            return 0;
        int leftChild = calculateDepth(root.left);
        int rightChild = calculateDepth(root.right);
        count = Math.max(leftChild+rightChild, count);
        return Math.max(leftChild,rightChild)+1;
    }
}