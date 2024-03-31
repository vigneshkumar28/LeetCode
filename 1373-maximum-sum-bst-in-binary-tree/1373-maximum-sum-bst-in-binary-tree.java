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
class Result{
    int min;
    int max;
    int maxSum;
    boolean isBST;
    Result(int min, int max, int maxSum, boolean isBST){
        this.min=min;
        this.max=max;
        this.maxSum=maxSum;
        this.isBST=isBST;
    }
}
class Solution {
    int ans;
    public int maxSumBST(TreeNode root) {
        ans=0;
        dfs(root);
        return ans;
    }
    public Result dfs(TreeNode root){
        if(root == null)
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE,0,true);
        Result leftChildResult= dfs(root.left);
        Result rightChildResult= dfs(root.right);
        if(leftChildResult.isBST && rightChildResult.isBST && root.val >leftChildResult.max && root.val<rightChildResult.min){
            int sum = root.val+leftChildResult.maxSum+rightChildResult.maxSum;
            int min = Math.min(root.val, leftChildResult.min);
            int max = Math.max(root.val, rightChildResult.max);
            ans = Math.max(ans, sum);
            return new Result(min, max, sum, true);
        }else{
         return new Result(0, 0, 0, false);   
        }
    }
}