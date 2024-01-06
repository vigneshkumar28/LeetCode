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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        //recursion
        flatten(root.left);
        flatten(root.right);
        //save tree for last
        TreeNode left = root.left;
        TreeNode right = root.right;
        //null left side and convert as only right
        root.left = null;
        root.right = left;
        // travel to end and make right side changes back to end of tree at the end
        TreeNode curr = root;
        while(curr.right!= null){
            curr = curr.right;
        }
        curr.right = right;
    }
}