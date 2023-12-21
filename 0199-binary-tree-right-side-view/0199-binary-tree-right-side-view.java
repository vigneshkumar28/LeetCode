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
    private static void solveHelper(TreeNode root, List<Integer> results, int depth){
        if(root == null)
            return;
        if(depth == results.size())
            results.add(root.val);
        solveHelper(root.right, results, depth+1);
        solveHelper(root.left, results, depth+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        solveHelper(root, results, 0);
        return results;
    }
}