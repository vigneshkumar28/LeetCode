/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode rightChild = lowestCommonAncestor(root.right, p, q);
        TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
        if(rightChild != null && leftChild != null)
            return root;
        else if(rightChild == null)
            return leftChild;
        else return rightChild;
    }
}