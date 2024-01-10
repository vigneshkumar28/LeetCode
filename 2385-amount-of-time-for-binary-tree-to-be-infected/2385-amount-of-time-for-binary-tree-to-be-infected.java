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
    int time = 0;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return time;
    }
    private int dfs(TreeNode root, int start){
        int depth = 0;
        if(root == null)
            return depth;
        int leftDepth = dfs(root.left, start);
        int rightDepth = dfs(root.right, start);
        if(root.val == start){
            time = Math.max(leftDepth, rightDepth);
            depth = -1;
        }
        else if(leftDepth >= 0 && rightDepth >= 0){
            depth= Math.max(leftDepth, rightDepth) + 1;
        }
        else{
            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            time = Math.max(time, distance);
            depth= Math.min(leftDepth, rightDepth) - 1;
        }
        return depth;
    }
}