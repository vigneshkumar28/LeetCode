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
    int tot=0;
    public TreeNode bstToGst(TreeNode root) {
        root = gst(root);
        return root;
    }
    private TreeNode gst(TreeNode node){
        if(node == null)
            return node;
        gst(node.right);
        tot += node.val;
        node.val = tot;
        gst(node.left);
        return node;
    }
}