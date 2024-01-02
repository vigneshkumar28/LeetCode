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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> result = new TreeSet<>();
        return helper(root, k, result);
    }
    private boolean helper(TreeNode root, int k, Set<Integer> result){
        if(root == null)
            return false;
        int balance = k - root.val;
        if(result.contains(balance))
            return true;
        result.add(root.val);
        return helper(root.left, k, result) || helper(root.right, k,result);
    }
}