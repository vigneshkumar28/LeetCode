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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode temp = root;
        for(int i=1; i<preorder.length; i++){
            insertNodeInBST(temp, preorder[i]);
        }
        return root;
    }
    private void insertNodeInBST(TreeNode temp, int value){
        if(value<temp.val){
                if(temp.left == null)
                    temp.left = new TreeNode(value);
                else
                    insertNodeInBST(temp.left, value);
            }else{
                if(temp.right == null)
                    temp.right = new TreeNode(value);
                else
                    insertNodeInBST(temp.right, value);
            }
    }
}